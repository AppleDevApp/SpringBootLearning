package com.idcut.mosmqtt.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatUserLeaveEvent extends MessageEvent {

    private String userTopic;

}
