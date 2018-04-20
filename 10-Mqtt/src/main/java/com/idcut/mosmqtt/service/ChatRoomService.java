package com.idcut.mosmqtt.service;

import com.idcut.mosmqtt.entity.ChatUserTalkRspBody;
import com.idcut.mosmqtt.entity.MsgSendWorker;
import com.idcut.mosmqtt.entity.ReplyMessageBody;
import com.idcut.mosmqtt.event.*;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import com.idcut.mosmqtt.pusher.EventPublisher;
import com.idcut.mosmqtt.util.JsonUtil;
import com.idcut.mosmqtt.util.ProtocolMsgUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Set;

@Slf4j
@Service
public class ChatRoomService {

    //@Autowired
    //private MqttPublisher mqttPublisher;

    @Autowired
    private EventPublisher eventBus;


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void sendChatMsg(ChatMsgSendEvent msgSendEvent) {
        ReplyMessageBody replyBody = buildChatMessage(msgSendEvent);
        sendChatMessageToUser(replyBody, msgSendEvent);
    }

    public void systemResponse(SystemResponseEvent responseEvent) {
        ReplyMessageBody replyBody = buildReply(responseEvent);
        ProtocolMsg msg = new ProtocolMsg();
        msg.getHeader().setRequest_id(responseEvent.getReqId());
        msg.getExtensionHeader().setService(responseEvent.getService());
        msg.setBody(JsonUtil.toJson(replyBody));
        byte[] payload = ProtocolMsgUtil.messageToByte(msg);
        //mqttPublisher.sendMsgByte(payload, responseEvent.getUserTopic());
        MsgSendWorker worker = new MsgSendWorker(payload, responseEvent.getUserTopic());
        eventBus.sendMsg(worker);
    }

    public void addUserToRoom(ChatUserEntryEvent userEntryEvent) {
        //发送到聊天室
        ReplyMessageBody replyBody = buildChatMessage(userEntryEvent);
        sendChatMessageToUser(replyBody, userEntryEvent);

        //添加用户到用户列表
        redisTemplate.opsForSet().add("chatroom_user_list" + userEntryEvent.getRoomId(), userEntryEvent.getUserTopic());
    }

    public void delUserFromRoom(ChatUserLeaveEvent userLeaveEvent) {
        //移除用户出用户列表
        redisTemplate.opsForSet().remove("chatroom_user_list" + userLeaveEvent.getRoomId(), userLeaveEvent.getUserTopic());

        //发送到聊天室
        ReplyMessageBody replyBody = buildChatMessage(userLeaveEvent);
        sendChatMessageToUser(replyBody, userLeaveEvent);
    }

    private ReplyMessageBody buildReply(MessageEvent event) {
        ReplyMessageBody replyBody = new ReplyMessageBody();
        replyBody.setMessage(event.getMessage());
        replyBody.setMsgBody(event.getContent());
        replyBody.setMsgDate(new Date());
        replyBody.setStatus(event.getStatus());
        replyBody.setMsgOp(event.getMsgOp());
        return replyBody;
    }

    private void groupSendMsgToUser(Set<String> userTopicSet, byte[] payload) {
        if (!CollectionUtils.isEmpty(userTopicSet)) {
            for (String userTopic : userTopicSet) {
                //mqttPublisher.sendMsgByte(payload, userTopic);
                MsgSendWorker worker = new MsgSendWorker(payload, userTopic);
                eventBus.sendMsg(worker);
            }
        }
    }

    private ReplyMessageBody buildChatMessage(MessageEvent event) {
        ChatUserTalkRspBody chatBody = new ChatUserTalkRspBody();
        BeanUtils.copyProperties(event, chatBody);

        ReplyMessageBody replyBody = new ReplyMessageBody();
        replyBody.setMessage("服务推送消息");
        replyBody.setMsgBody(chatBody);
        replyBody.setMsgDate(new Date());
        replyBody.setStatus(event.getStatus());
        replyBody.setMsgOp(event.getMsgOp());
        return replyBody;
    }

    private void sendChatMessageToUser(ReplyMessageBody replyBody, MessageEvent event) {
        //获取最新到用户列表
        Set<String> userTopicSet = redisTemplate.opsForSet().members("chatroom_user_list" + event.getRoomId());

        ProtocolMsg msg = new ProtocolMsg();
        msg.getHeader().setRequest_id(event.getReqId());
        msg.getExtensionHeader().setService("Server_ChatRoom_SendMsg");
        msg.setBody(JsonUtil.toJson(replyBody));
        byte[] payload = ProtocolMsgUtil.messageToByte(msg);
        groupSendMsgToUser(userTopicSet, payload);
    }

}
