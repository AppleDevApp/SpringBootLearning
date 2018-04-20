package com.idcut.mosmqtt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatUserEntryBody {

    private String roomId;
    private String msgFrom;
    private String msgTo;
    private Integer msgType;
    private String content;

}
