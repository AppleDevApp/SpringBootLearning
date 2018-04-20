package com.idcut.mosmqtt.handler.chatroom;

import com.idcut.mosmqtt.entity.TopicMeta;
import com.idcut.mosmqtt.handler.protocol.ModuleOperateProtocol;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service("chatRoomPrintMessageHandler")
public class PrintMessageHandler implements ModuleOperateProtocol {

    @Override
    public void handleMessage(Message<ProtocolMsg> message, TopicMeta meta) {
        log.info("收到消息{}", message.getPayload().getBody());
    }

}
