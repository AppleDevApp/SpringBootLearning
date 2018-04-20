package com.idcut.mosmqtt.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlatformPayload<T> {

    private String revId;
    private String token;
    private T msgBody;
}
