package com.idcut.mosmqtt;

import com.idcut.mosmqtt.config.MqttConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MqttConfig.class)
public class MosMqttApplication {

    public static void main(String[] args) {
        SpringApplication.run(MosMqttApplication.class, args);
    }
}
