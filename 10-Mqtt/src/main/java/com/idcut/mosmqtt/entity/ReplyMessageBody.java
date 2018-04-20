package com.idcut.mosmqtt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReplyMessageBody {

    private String msgOp;
    private Object msgBody;
    private Date msgDate;
    private Integer status;
    private String message;

}
