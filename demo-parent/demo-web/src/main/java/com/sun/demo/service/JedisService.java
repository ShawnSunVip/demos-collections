package com.sun.demo.service;

/**
 * @author sunxiang
 * @date 2020-12-18 9:41
 **/
public interface JedisService {

    public String getRedisLock(String lockKey);

    public void unRedisLock(String lockKey,String lockValue);
}
