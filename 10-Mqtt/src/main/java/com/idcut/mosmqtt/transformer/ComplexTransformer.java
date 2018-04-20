package com.idcut.mosmqtt.transformer;

import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapperProvider;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.util.StringUtils;

public class ComplexTransformer extends AbstractTransformer {

    private final Class<?> targetClass;

    public ComplexTransformer() {
        this(null);
    }

    public ComplexTransformer(Class<?> targetClass) {
        this.targetClass = targetClass;
    }


    @Override
    protected Object doTransform(Message<?> message) throws Exception {
        String payloadOrgin = message.getPayload().toString();

        //假设里面用----Content----分隔
        String payload = StringUtils.split(payloadOrgin, "----Content----")[1];
        JsonObjectMapper<?, ?> jsonObjectMapper = JsonObjectMapperProvider.newInstance();
        return jsonObjectMapper.fromJson(payload, this.targetClass);
    }

    public static AbstractTransformer getTransformer(Class<?> targetClass) {
        return new ComplexTransformer(targetClass);
    }
}
