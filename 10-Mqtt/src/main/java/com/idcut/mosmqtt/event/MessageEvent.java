package com.idcut.mosmqtt.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class MessageEvent {

    private String msgId;
    private String roomId;
    private String msgOp;
    private String msgFrom;
    private String msgTo;
    private Integer msgType;
    private Object content;
    private Date msgDate;
    private String userTopic;
    private String reqId;
    private String service;
    private String message;
    private Integer status;

}
