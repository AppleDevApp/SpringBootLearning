package com.idcut.mosmqtt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatRoomPayload {

    private String reqid;
    private String revId;
    private String cmd;
    private String token;
    private String raw;
    private String msgBody;

}
