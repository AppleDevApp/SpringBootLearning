package com.idcut.mosmqtt.listener.chatroom;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import com.idcut.mosmqtt.entity.MsgSendWorker;
import com.idcut.mosmqtt.mqtt.MqttPusherConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Slf4j
@Component
public class MsgWorkerEventListener {

//    @Resource(name = "syncEventBus")
//    private EventBus eventBus;

    @Autowired
    private AsyncEventBus eventBus;

    @Resource
    private MqttPusherConfiguration.PushGateway pushGateway;

    @Resource
    private MqttClient mqttClient;

    //注册这个监听器
    @PostConstruct
    public void register() {
        eventBus.register(this);
    }

    //解除这个监听器
    @PreDestroy
    public void unregister() {
        eventBus.unregister(this);
    }

    @Subscribe
    public void sendMsgWork(MsgSendWorker msgSendWorker) {
        sendInner(msgSendWorker);
    }

    private void sendInner(MsgSendWorker msgSendWorker) {
        try {
            //pushGateway.sendToMqttByte(msgSendWorker.getPayload(), msgSendWorker.getTopic());
            mqttClient.publish(msgSendWorker.getTopic(), msgSendWorker.getPayload(), 1, false);
        } catch (Exception ex) {
            log.error("Send Msg Failed:{}", ex);
        }
    }

}
