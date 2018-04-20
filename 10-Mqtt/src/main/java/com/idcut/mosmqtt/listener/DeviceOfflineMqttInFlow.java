package com.idcut.mosmqtt.listener;

import com.idcut.mosmqtt.constant.ClientDevice;
import com.idcut.mosmqtt.constant.MessageDefine;
import com.idcut.mosmqtt.constant.MessageTopic;
import com.idcut.mosmqtt.constant.SubscribeChannel;
import com.idcut.mosmqtt.domain.ChatRoomPayload;
import com.idcut.mosmqtt.handler.chatroom.ChatRoomMessageHandler;
import com.idcut.mosmqtt.mqtt.MqttListenConfiguration;
import com.idcut.mosmqtt.util.FlowDefineBuilder;
import com.idcut.mosmqtt.util.MessageConvert;
import com.idcut.mosmqtt.util.TopicExtract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

@Configuration
public class DeviceOfflineMqttInFlow {

    @Autowired
    private MqttListenConfiguration mqttListenConfiguration;

    @Autowired
    private ChatRoomMessageHandler chatRoomMessageHandler;

    /**
     * Message Producer which connects to MQTT server and consumes the configured mqttTopics
     * And will place it in mqttMessageEnrichChannel
     */
    @Bean
    public MessageProducerSupport chatroomMessageInbound() {
        String[] chatRoomTopic = new String[]{MessageTopic.CHATROOM_TOPIC};
        return mqttListenConfiguration.buildTopicInbound(ClientDevice.CHATROOM_DEVICE, chatRoomTopic);
    }

    @Bean
    public IntegrationFlow chatRoomHandleInFlow() {
        IntegrationFlowBuilder flowDefinition = FlowDefineBuilder.
                buildFlow(SubscribeChannel.CHATROOM_CHANNEL,
                        chatroomMessageInbound(), chatRoomMessageHandler);

        AbstractTransformer transformer = MessageConvert.transform(
                MessageDefine.PayloadType.JSON,
                ChatRoomPayload.class);

        return flowDefinition.transform(transformer)
                .enrich(e -> e
                        .requestPayload(Message::getPayload)
                        .propertyFunction("cmd", m -> TopicExtract.extractParamFromTopic(m)))
                .handle(chatRoomMessageHandler).get();
    }
}
