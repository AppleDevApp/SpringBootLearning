package com.idcut.mosmqtt.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicMeta {

    private String prefix;
    private String module;
    private String operate;
    private String data;

}
