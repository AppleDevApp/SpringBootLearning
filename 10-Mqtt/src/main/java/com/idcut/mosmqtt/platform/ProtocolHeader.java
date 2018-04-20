package com.idcut.mosmqtt.platform;

import com.idcut.mosmqtt.util.UniqueId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProtocolHeader {

    private String request_id;
    private String time_sec;

    public ProtocolHeader() {
        request_id = UniqueId.getLongId().toString();
        time_sec = String.valueOf(System.currentTimeMillis());
    }

    public ProtocolHeader(String requestId) {
        request_id = requestId;
        time_sec = String.valueOf(System.currentTimeMillis());
    }

}
