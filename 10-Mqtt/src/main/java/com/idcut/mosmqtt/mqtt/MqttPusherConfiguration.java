package com.idcut.mosmqtt.mqtt;

import com.idcut.mosmqtt.config.MqttConfig;
import com.idcut.mosmqtt.constant.PublishChannel;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Header;

@Configuration
public class MqttPusherConfiguration {

    @Autowired
    private MqttConfig mqttConfig;

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    @Bean
    @ServiceActivator(inputChannel = PublishChannel.DEFAULT_CHANNEL)
    public MessageHandler mqttOutboundWithClientId() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
                mqttConfig.getPushClientId(), mqttClientFactory);
        messageHandler.setDefaultQos(1);
        DefaultPahoMessageConverter msgConvert = new DefaultPahoMessageConverter();
        msgConvert.setPayloadAsBytes(true);
        messageHandler.setConverter(msgConvert);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(mqttConfig.getPushTopic());
        return messageHandler;
    }

    @MessagingGateway(defaultRequestChannel = PublishChannel.DEFAULT_CHANNEL)
    public interface PushGateway {
        void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);

        void sendToMqttByte(byte[] payload, @Header(MqttHeaders.TOPIC) String topic);
    }

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient mqttClient = new MqttClient(mqttConfig.getBrokerAddress(), mqttConfig.getPushClientId() + "CLI");
        MqttConnectOptions connOptions = new MqttConnectOptions();
//        connOptions.setUserName("");
//        connOptions.setPassword("");
        mqttClient.connect(connOptions);
        return mqttClient;
    }
}
