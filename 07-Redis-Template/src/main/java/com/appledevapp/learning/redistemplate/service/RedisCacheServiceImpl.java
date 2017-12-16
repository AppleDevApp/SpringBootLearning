package com.appledevapp.learning.redistemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <T> T getCacheValue(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setCacheValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setCacheValueForTime(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    @Override
    public void delCacheByKey(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean existInCache(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public boolean expireWithKey(String key, long expireTime) {
        return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }
}
