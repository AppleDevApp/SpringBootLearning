package com.appledevapp.learning.redistemplate.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

/**
 * 自定义redis序列化控制器
 * 默认的redis-template存入redis值会带上类型信息
 */
public class RedisJsonSerializer implements RedisSerializer<Object> {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            return EMPTY_ARRAY;
        } else {
            try {
                return this.objectMapper.writeValueAsBytes(t);
            } catch (Exception ex) {
                throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        } else {
            try {
                return this.objectMapper.readValue(bytes, 0, bytes.length, Object.class);
            } catch (Exception ex) {
                throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
            }
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "'objectMapper' must not be null");
        this.objectMapper = objectMapper;
    }

    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
