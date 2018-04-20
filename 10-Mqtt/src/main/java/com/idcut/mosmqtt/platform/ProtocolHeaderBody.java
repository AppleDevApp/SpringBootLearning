package com.idcut.mosmqtt.platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProtocolHeaderBody {

    private int version = 0;
    private int h_length;
    private int h_type;
    private long ext_length;

}
