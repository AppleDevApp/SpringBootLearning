package com.idcut.mosmqtt.pusher;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private AsyncEventBus asyncEventBus;

    public void sendMsg(Object event) {
        asyncEventBus.post(event);
    }
}
