package com.idcut.mosmqtt.transformer;

import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.transformer.AbstractTransformer;

public class JsonTransformer {

    public static AbstractTransformer getTransformer(Class<?> targetClass) {
        return Transformers.fromJson(targetClass);
    }
}
