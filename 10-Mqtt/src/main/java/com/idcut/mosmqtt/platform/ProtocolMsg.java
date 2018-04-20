package com.idcut.mosmqtt.platform;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProtocolMsg {

    private ProtocolHeaderBody headerInfo;
    private ProtocolHeader header;
    private ProtocolExtHeader extensionHeader;
    private String body;

    public ProtocolMsg() {
        headerInfo = new ProtocolHeaderBody();
        header = new ProtocolHeader();
        extensionHeader = new ProtocolExtHeader();
    }

}
