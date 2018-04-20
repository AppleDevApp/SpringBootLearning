package com.idcut.mosmqtt.mqtt;

import com.idcut.mosmqtt.config.MqttConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.util.StringUtils;

@Configuration
public class MqttConfiguration {

    @Autowired
    private MqttConfig mqttConfig;

    /**
     * MQTT Client Factory for connecting with MQTT Server with Authentication
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs(mqttConfig.getBrokerAddress());
        if (StringUtils.hasText(mqttConfig.getUsername())) {
            factory.setUserName(mqttConfig.getUsername());
        }
        if (StringUtils.hasText(mqttConfig.getPassword())) {
            factory.setPassword(mqttConfig.getPassword());
        }
        //factory.setPersistence(new MemoryPersistence());
        //factory.setKeepAliveInterval(10000);
        return factory;
    }
}
