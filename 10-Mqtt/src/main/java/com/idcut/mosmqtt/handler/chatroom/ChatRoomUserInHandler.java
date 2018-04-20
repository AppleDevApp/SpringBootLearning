package com.idcut.mosmqtt.handler.chatroom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.idcut.mosmqtt.constant.MessageDefine;
import com.idcut.mosmqtt.constant.StatusCode;
import com.idcut.mosmqtt.domain.PlatformPayload;
import com.idcut.mosmqtt.entity.ChatUserEntryBody;
import com.idcut.mosmqtt.entity.TopicMeta;
import com.idcut.mosmqtt.event.ChatUserEntryEvent;
import com.idcut.mosmqtt.handler.protocol.ModuleOperateProtocol;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import com.idcut.mosmqtt.pusher.EventPublisher;
import com.idcut.mosmqtt.service.TokenValidateService;
import com.idcut.mosmqtt.util.JsonUtil;
import com.idcut.mosmqtt.util.UniqueId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service("chatRoomUserInHandler")
public class ChatRoomUserInHandler implements ModuleOperateProtocol {

    //chatRoom/UserIn

    @Autowired
    private TokenValidateService tokenService;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public void handleMessage(Message<ProtocolMsg> message, TopicMeta meta) {
        //进入房间
        TypeReference typeReference = new TypeReference<PlatformPayload<ChatUserEntryBody>>() {
        };
        PlatformPayload<ChatUserEntryBody> payload = JsonUtil.fromJson(
                message.getPayload().getBody(),
                typeReference);

        ChatUserEntryBody body = payload.getMsgBody();

        //SystemResponseEvent rspEvent = tokenService.validateWithResult(message, meta, payload.getRevId(), payload.getToken());
        //eventPublisher.sendMsg(rspEvent);

        ChatUserEntryEvent event = new ChatUserEntryEvent();
        event.setMsgId(UniqueId.getLongId().toString());
        event.setReqId(message.getPayload().getHeader().getRequest_id());
        event.setUserTopic(payload.getRevId());
        event.setRoomId(body.getRoomId());
        event.setMsgFrom(body.getMsgFrom());
        event.setMsgType(MessageDefine.MessageType.SYSTEM.ordinal());
        event.setMsgOp(meta.getOperate());
        event.setService(message.getPayload().getExtensionHeader().getService());
        event.setMsgTo(body.getMsgTo());
        event.setMsgDate(new Date());
        event.setContent(String.format("%s进入了房间,快来聊天吧", body.getMsgFrom()));
        event.setStatus(StatusCode.SUCCESS);
        event.setMessage("成功");
        eventPublisher.sendMsg(event);
    }

}
