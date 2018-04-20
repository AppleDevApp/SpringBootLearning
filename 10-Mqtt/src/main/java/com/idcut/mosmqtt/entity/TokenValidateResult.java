package com.idcut.mosmqtt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenValidateResult {

    private Integer code;
    private String msg;
    private Integer uid;
    private String userName;

}
