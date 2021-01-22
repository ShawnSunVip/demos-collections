package com.sun.spike;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 订阅者
 * @author sunxiang
 * @date 2021-01-22 16:15
 **/
public class Subscribe implements Runnable{

    private final SubscribePublish subscribePublish =new SubscribePublish();

    @Override
    public void run() {
        JedisPool jedisPool = JedisPoolUtils.getInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(subscribePublish,"mychannel");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis !=null){
                jedis.close();
            }
        }

    }
}
