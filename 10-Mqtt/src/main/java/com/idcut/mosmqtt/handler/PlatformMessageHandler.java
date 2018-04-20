package com.idcut.mosmqtt.handler;

import com.google.common.primitives.Longs;
import com.idcut.mosmqtt.constant.MessageTopic;
import com.idcut.mosmqtt.entity.TopicMeta;
import com.idcut.mosmqtt.handler.protocol.MessageHandleProtocol;
import com.idcut.mosmqtt.handler.protocol.ModuleOperateProtocol;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import com.idcut.mosmqtt.util.SpringBeanUtils;
import com.idcut.mosmqtt.util.TopicExtract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.springframework.integration.mqtt.support.MqttHeaders.RECEIVED_TOPIC;

@Slf4j
@Component
public class PlatformMessageHandler implements MessageHandleProtocol<ProtocolMsg> {

    public List<String> registBeanList = Arrays.asList(new String[]{
            "chatRoomSendMsgHandler",
            "chatRoomUserInHandler",
            "chatRoomUserOutHandler",
            "chatRoomPrintMessageHandler",
            "deviceOfflineHandler"
    });

    public void handleMessage(Message<ProtocolMsg> message) {
        log.info("Receive Platform Msg {}", message.getPayload());

        try {
            Long now = System.currentTimeMillis();
            Long msgDate = Longs.tryParse(message.getPayload().getHeader().getTime_sec());
            if (now - msgDate > 25000) {
                log.error("Msg Over Time For 25 seconds:{}", message);
                return;
            }

            //prefix/module/operate/data
            String topic = message.getHeaders().get(RECEIVED_TOPIC).toString();

            if (topic.equals(MessageTopic.OFFLINE_TOPIC)) {
                topic = "iot/device/Offline";
            }

            TopicMeta meta = TopicExtract.extractMeta(topic);
            String handlerName = String.format("%s%sHandler", meta.getModule(), meta.getOperate());
            if (registBeanList.contains(handlerName)) {
                ModuleOperateProtocol handler = SpringBeanUtils.getBean(handlerName, ModuleOperateProtocol.class);
                handler.handleMessage(message, meta);
            }

        } catch (Exception ex) {
            log.error("Handle Msg Failed:{}", ex);
        }
    }


}
