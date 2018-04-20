package com.idcut.mosmqtt.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.idcut.mosmqtt.entity.TopicMeta;
import org.springframework.messaging.Message;

import java.util.List;

import static org.springframework.integration.mqtt.support.MqttHeaders.RECEIVED_TOPIC;

public class TopicExtract {

    public static Message extractMessage(Message<Object> m) {
        return m;
    }

    public static String extractParamFromTopic(Message<Object> m) {
        String topic = m.getHeaders().get(RECEIVED_TOPIC).toString();
        return topic.substring(topic.lastIndexOf("/") + 1, topic.length());
    }

    public static TopicMeta extractMeta(String topic) {
        Iterable<String> iterable = Splitter.on('/')
                .trimResults()
                .omitEmptyStrings()
                .split(topic);
        List<String> metaList = Lists.newArrayList(iterable);
        TopicMeta meta = new TopicMeta();
        if (metaList.size() >= 3) {
            meta.setPrefix(metaList.get(0));
            meta.setModule(metaList.get(1));
            meta.setOperate(metaList.get(2));
        }

        if (metaList.size() >= 4) {
            meta.setData(metaList.get(3));
        }

        return meta;
    }
}
