package com.idcut.mosmqtt.util;

import com.idcut.mosmqtt.constant.MessageDefine;
import com.idcut.mosmqtt.transformer.JsonTransformer;
import com.idcut.mosmqtt.transformer.PlatformTransformer;
import org.springframework.integration.transformer.AbstractTransformer;

public class MessageConvert {

    public static AbstractTransformer transform(MessageDefine.PayloadType payloadType, Class<?> targetClass) {
        switch (payloadType) {
            case STRING: {
                return null;
            }
            case JSON: {
                return JsonTransformer.getTransformer(targetClass);
            }
            case PLATFORM: {
                return PlatformTransformer.getTransformer();
            }
            default: {
                return null;
            }
        }
    }
}
