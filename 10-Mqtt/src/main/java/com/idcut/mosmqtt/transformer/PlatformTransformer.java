package com.idcut.mosmqtt.transformer;

import com.idcut.mosmqtt.util.ProtocolMsgUtil;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

public class PlatformTransformer extends AbstractTransformer {

    @Override
    protected Object doTransform(Message<?> message) throws Exception {
        byte[] payloadByte = (byte[]) message.getPayload();
        return ProtocolMsgUtil.byteToMessage(payloadByte);
    }

    public static AbstractTransformer getTransformer() {
        return new PlatformTransformer();
    }
}
