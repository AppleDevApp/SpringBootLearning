package com.idcut.mosmqtt.listener;

import com.idcut.mosmqtt.constant.ClientDevice;
import com.idcut.mosmqtt.constant.MessageDefine;
import com.idcut.mosmqtt.constant.MessageTopic;
import com.idcut.mosmqtt.constant.SubscribeChannel;
import com.idcut.mosmqtt.handler.PlatformMessageHandler;
import com.idcut.mosmqtt.mqtt.MqttListenConfiguration;
import com.idcut.mosmqtt.util.FlowDefineBuilder;
import com.idcut.mosmqtt.util.MessageConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.transformer.AbstractTransformer;

@Configuration
public class PlatformMqttInFlow {

    @Autowired
    private MqttListenConfiguration mqttListenConfiguration;

    @Autowired
    private PlatformMessageHandler platformMessageHandler;

    /**
     * Message Producer which connects to MQTT server and consumes the configured mqttTopics
     * And will place it in mqttMessageEnrichChannel
     */
    @Bean
    public MessageProducerSupport platformMessageInbound() {
        String[] msgTopic = new String[]{MessageTopic.PLATFORM_TOPIC, MessageTopic.OFFLINE_TOPIC};
        return mqttListenConfiguration.buildTopicInbound(ClientDevice.PLATFORM_DEVICE, msgTopic);
    }

    @Bean
    public IntegrationFlow platformHandleInFlow() {
        IntegrationFlowBuilder flowDefinition = FlowDefineBuilder.
                buildFlow(SubscribeChannel.PLATFORM_CHANNEL,
                        platformMessageInbound(), platformMessageHandler);

        AbstractTransformer transformer = MessageConvert.transform(
                MessageDefine.PayloadType.PLATFORM,
                null);

        return flowDefinition.transform(transformer).handle(platformMessageHandler).get();
    }
}
