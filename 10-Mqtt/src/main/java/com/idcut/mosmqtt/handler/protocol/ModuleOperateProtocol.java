package com.idcut.mosmqtt.handler.protocol;

import com.idcut.mosmqtt.entity.TopicMeta;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import org.springframework.messaging.Message;

public interface ModuleOperateProtocol {

    void handleMessage(Message<ProtocolMsg> message, TopicMeta meta);
}
