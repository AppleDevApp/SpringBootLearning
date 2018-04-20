package com.idcut.mosmqtt.pusher;

import com.idcut.mosmqtt.mqtt.MqttPusherConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapperProvider;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class MqttPublisher {

    private JsonObjectMapper<?, ?> jsonObjectMapper = JsonObjectMapperProvider.newInstance();

    @Resource
    private MqttPusherConfiguration.PushGateway pushGateway;

    public void sendMsg(String payload, String topic) {
        pushGateway.sendToMqtt(payload, topic);
    }

    public void sendMsgByte(byte[] payload, String topic) {
        pushGateway.sendToMqttByte(payload, topic);
    }

    public void sendMsgWithObject(Object payloadBody, String topic) {
        try {
            String payload = jsonObjectMapper.toJson(payloadBody);
            sendMsg(payload, topic);
        } catch (Exception ex) {
            log.error("Send Mqtt Msg Error:{}", ex);
        }
    }

    private String encodeMsg(byte[] payloadByte) {
        try {
            return new String(payloadByte, "UTF-8");
        } catch (Exception ex) {
            log.error("Encode Msg Failed:{}", ex);
        }

        return "";
    }
}
