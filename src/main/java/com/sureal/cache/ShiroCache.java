package com.sureal.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Wuxx
 * @date 2019/5/28 10:17
 * @PackageName com.sureal.shiro
 * @ClassName ShiroCache
 * @Description Shiro缓存管理
 */

public class ShiroCache<K, V> implements Cache<K, V> {

    private static final String REDIS_SHIRO_CACHE = "shiro_redis_session";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;
    private long globExpire = 30;

    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = REDIS_SHIRO_CACHE;
        this.redisTemplate = client;
    }


    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
        return (K) (this.cacheKey + k);
    }
}
