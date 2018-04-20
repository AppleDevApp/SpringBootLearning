package com.idcut.mosmqtt.handler;

import com.idcut.mosmqtt.domain.DefaultPayload;
import com.idcut.mosmqtt.handler.protocol.MessageHandleProtocol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultMessageHandler implements MessageHandleProtocol<DefaultPayload> {

    public void handleMessage(Message<DefaultPayload> message) {
        try {
            log.info("Receive Default Msg {}", message.getPayload());
        } catch (Exception ex) {
            log.error("Failed To Handle Msg:{}", ex);
        }
    }

}
