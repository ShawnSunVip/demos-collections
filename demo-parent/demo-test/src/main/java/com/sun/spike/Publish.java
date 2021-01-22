package com.sun.spike;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 发布者
 * @author sunxiang
 * @date 2021-01-22 16:06
 **/
public class Publish implements Runnable{

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        JedisPool jedisPool = JedisPoolUtils.getInstance();
        Jedis jedis = jedisPool.getResource();
        while (true){
            String line=null;
            try {
                line =bufferedReader.readLine();
                if(!"quit".equals(line)){
                    jedis.publish("mychannel",line);
                }else{
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
