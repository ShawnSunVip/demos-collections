package com.sun.spike;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author sunxiang
 * @date 2021-01-22 14:02
 **/
public class JedisPoolUtils {
    private JedisPoolUtils(){}
    private static JedisPool jedisPool;

    public static JedisPool getInstance(){
        if(jedisPool == null){
            synchronized (JedisPoolUtils.class){
                if(jedisPool == null){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(1000);
                    jedisPoolConfig.setMaxIdle(10);
                    jedisPoolConfig.setBlockWhenExhausted(true);
                    jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379,1000,"123456");
                }
            }
        }
        return jedisPool;
    }

    public static void main(String[] args) {
        jedisPool = getInstance();
        Jedis jedis = jedisPool.getResource();

        String ping = jedis.ping();
        System.out.println(ping);
        jedis.close();
    }
}
