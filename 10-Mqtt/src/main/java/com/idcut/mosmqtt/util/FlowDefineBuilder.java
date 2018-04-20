package com.idcut.mosmqtt.util;

import com.idcut.mosmqtt.constant.SystemConstant;
import com.idcut.mosmqtt.handler.protocol.MessageHandleProtocol;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;

public class FlowDefineBuilder {

    public static LoggingHandler getChannelLogger(String channel) {
        LoggingHandler loggingHandler = new LoggingHandler(LoggingHandler.Level.INFO);
        loggingHandler.setLoggerName(String.format(SystemConstant.APPEND_FORMAT, SystemConstant.LOGGER_NAME, channel));
        return loggingHandler;
    }

    public static IntegrationFlowBuilder buildFlow(String channel, MessageProducerSupport messageSource, MessageHandleProtocol messageHandle) {
        return IntegrationFlows.from(messageSource)

                // log the incoming message
                .wireTap(sf -> sf.handle(getChannelLogger(channel)));

                // our handler doesn't receive meta data, only the payload.
//                .handle(messageHandle);
    }
}
