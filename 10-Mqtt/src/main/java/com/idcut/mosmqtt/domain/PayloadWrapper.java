package com.idcut.mosmqtt.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.Message;

@Getter
@Setter
public class PayloadWrapper<T> {

    private Message message;

    private T body;

}
