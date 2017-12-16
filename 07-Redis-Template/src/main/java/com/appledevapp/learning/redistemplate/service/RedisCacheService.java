package com.appledevapp.learning.redistemplate.service;

/**
 * Redis服务封装，仅封装了部分，有空再完善
 */
public interface RedisCacheService {

    /**
     * 获取指定键值的对象
     *
     * @param key 缓存键值
     * @param <T> 类型
     * @return 缓存中对象值
     */
    <T> T getCacheValue(String key);

    /**
     * 设置缓存键值
     *
     * @param key   缓存键值
     * @param value 缓存对象
     */
    void setCacheValue(String key, Object value);

    /**
     * 设置缓存键值并设置有效期
     *
     * @param key 缓存键值
     * @param value 缓存对象
     * @param expireTime 过期时间
     */
    void setCacheValueForTime(String key, Object value, long expireTime);

    /**
     * 根据指定键值删除缓存
     *
     * @param key 缓存键值
     */
    void delCacheByKey(String key);

    /**
     * 判断缓存中是否存在键值
     *
     * @param key 缓存键值
     * @return 存在返回true
     */
    boolean existInCache(String key);

    /**
     * 给键值设置过期时间
     *
     * @param key        缓存键值
     * @param expireTime 过期时间
     * @return 是否成功
     */
    boolean expireWithKey(String key, long expireTime);
}
