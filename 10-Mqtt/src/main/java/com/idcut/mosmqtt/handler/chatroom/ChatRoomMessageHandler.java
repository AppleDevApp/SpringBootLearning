package com.idcut.mosmqtt.handler.chatroom;

import com.idcut.mosmqtt.domain.ChatRoomPayload;
import com.idcut.mosmqtt.entity.ChatUserEntryBody;
import com.idcut.mosmqtt.entity.ChatUserLeaveBody;
import com.idcut.mosmqtt.entity.ChatUserTalkBody;
import com.idcut.mosmqtt.event.ChatMsgSendEvent;
import com.idcut.mosmqtt.event.ChatUserEntryEvent;
import com.idcut.mosmqtt.event.ChatUserLeaveEvent;
import com.idcut.mosmqtt.handler.protocol.MessageHandleProtocol;
import com.idcut.mosmqtt.pusher.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapperProvider;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatRoomMessageHandler implements MessageHandleProtocol<ChatRoomPayload> {

    @Autowired
    private EventPublisher eventPublisher;

    private JsonObjectMapper<?, ?> jsonObjectMapper = JsonObjectMapperProvider.newInstance();

    public void handleMessage(Message<ChatRoomPayload> message) {
        log.info("Receive ChatRoom Msg {}", message.getPayload());

        try {
            ChatRoomPayload payload = message.getPayload();
            switch (payload.getCmd()) {
                case "userin": {
                    //进入房间
                    ChatUserEntryBody body = jsonObjectMapper.fromJson(payload.getMsgBody(), ChatUserEntryBody.class);
                    ChatUserEntryEvent event = new ChatUserEntryEvent();
                    BeanUtils.copyProperties(body, event);
                    event.setMsgId(payload.getReqid());
                    event.setUserTopic(payload.getRevId());
                    event.setContent(String.format("%s进入了房间", body.getMsgFrom()));
                    eventPublisher.sendMsg(event);
                    break;
                }
                case "userout": {
                    //离开房间
                    ChatUserLeaveBody body = jsonObjectMapper.fromJson(payload.getMsgBody(), ChatUserLeaveBody.class);
                    ChatUserLeaveEvent event = new ChatUserLeaveEvent();
                    BeanUtils.copyProperties(body, event);
                    event.setMsgId(payload.getReqid());
                    event.setUserTopic(payload.getRevId());
                    event.setContent(String.format("%s离开了房间", body.getMsgFrom()));
                    eventPublisher.sendMsg(event);
                    break;
                }
                case "sendmsg": {
                    //发送消息到聊天室
                    ChatUserTalkBody body = jsonObjectMapper.fromJson(payload.getMsgBody(), ChatUserTalkBody.class);
                    ChatMsgSendEvent event = new ChatMsgSendEvent();
                    BeanUtils.copyProperties(body, event);
                    event.setMsgId(payload.getReqid());
                    event.setContent(String.format("%s离开了房间", body.getMsgFrom()));
                    eventPublisher.sendMsg(event);
                }
                default: {
                    break;
                }
            }
        } catch (Exception ex) {
            log.error("Handle ChatRoom Msg Error:{}", ex);
        }
    }

}
