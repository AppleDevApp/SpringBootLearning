package com.idcut.mosmqtt.handler.protocol;

import org.springframework.messaging.Message;

public interface MessageHandleProtocol<T> {

    void handleMessage(Message<T> message);
}
