package com.idcut.mosmqtt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MsgSendWorker {

    private byte[] payload;
    private String topic;

}
