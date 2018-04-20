package com.idcut.mosmqtt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("iot.mqtt")
public class MqttConfig {

    private String brokerAddress;

    private String[] listenTopic;

    private String pushTopic;

    private String pushClientId;

    private String listenClientId;

    private Integer qos;

    private Integer completionTimeout;

    private String username;

    private String password;

}
