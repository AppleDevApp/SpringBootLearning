package com.idcut.mosmqtt.mqtt;

import com.idcut.mosmqtt.config.MqttConfig;
import com.idcut.mosmqtt.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;

@Configuration
public class MqttListenConfiguration {

    @Autowired
    private MqttConfig mqttConfig;

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    /**
     * Wrapper For Mqtt Message Producer
     */
    public MessageProducerSupport mqttInboundWithClientId(String clientId, String[] receiveTopic) {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory, receiveTopic);
        adapter.setCompletionTimeout(mqttConfig.getCompletionTimeout());
        DefaultPahoMessageConverter msgConvert = new DefaultPahoMessageConverter();
        msgConvert.setPayloadAsBytes(true);
        adapter.setConverter(msgConvert);
        adapter.setQos(mqttConfig.getQos());
        return adapter;
    }

    public MessageProducerSupport buildTopicInbound(String device, String[] receiveTopic) {
        String extClientId = buildExtClientId(device);
        return mqttInboundWithClientId(extClientId, receiveTopic);
    }

    public MqttConfig getConfig() {
        return mqttConfig;
    }

    public String buildExtClientId(String device) {
        return String.format(SystemConstant.APPEND_FORMAT, mqttConfig.getListenClientId(), device);
    }
}
