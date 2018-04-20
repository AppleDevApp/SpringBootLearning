package com.idcut.mosmqtt.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public final class JsonUtil {

    private static ObjectMapper objectMapper;

    //通过静态代码块，给变量赋值
    static {
        objectMapper = SpringBeanUtils.getBean(ObjectMapper.class);
    }

    public static String toJson(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (Exception ex) {
            log.error("Serialize Object Json Failed:{}", ex);
        }

        return null;
    }

    public static <T> T fromJson(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (Exception ex) {
            log.error("DeSerialize Json Object Failed:{}", ex);
        }

        return null;
    }

    public static <T> T fromJson(String json, TypeReference typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception ex) {
            log.error("DeSerialize Json Object Failed:{}", ex);
        }

        return null;
    }

    public static <T> T fromJsonList(String json, Class<T> targetClass) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, targetClass);
            return objectMapper.readValue(json, javaType);
        } catch (Exception ex) {
            log.error("DeSerialize Json Object Failed:{}", ex);
        }

        return null;
    }

    public static <T> T fromJsonList(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (Exception ex) {
            log.error("DeSerialize Json Object Failed:{}", ex);
        }

        return null;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
