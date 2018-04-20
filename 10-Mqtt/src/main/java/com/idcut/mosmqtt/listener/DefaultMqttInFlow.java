package com.idcut.mosmqtt.listener;

import com.idcut.mosmqtt.constant.ClientDevice;
import com.idcut.mosmqtt.constant.MessageDefine;
import com.idcut.mosmqtt.constant.SubscribeChannel;
import com.idcut.mosmqtt.domain.DefaultPayload;
import com.idcut.mosmqtt.handler.DefaultMessageHandler;
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
public class DefaultMqttInFlow {

    @Autowired
    private MqttListenConfiguration mqttListenConfiguration;

    @Autowired
    private DefaultMessageHandler defaultMessageHandler;

    /**
     * Message Producer which connects to MQTT server and consumes the configured mqttTopics
     * And will place it in mqttMessageEnrichChannel
     */
    @Bean
    public MessageProducerSupport defaultMessageInbound() {
        String[] defaultTopic = mqttListenConfiguration.getConfig().getListenTopic();
        return mqttListenConfiguration.buildTopicInbound(ClientDevice.DEFAULT_DEVICE, defaultTopic);
    }

    @Bean
    public IntegrationFlow defaultHandleInFlow() {
        IntegrationFlowBuilder flowDefinition = FlowDefineBuilder.
                buildFlow(SubscribeChannel.DEFAULT_CHANNEL,
                        defaultMessageInbound(), defaultMessageHandler);

        AbstractTransformer transformer = MessageConvert.transform(
                MessageDefine.PayloadType.JSON,
                DefaultPayload.class);

        return flowDefinition.transform(transformer).handle(defaultMessageHandler).get();
    }
}
