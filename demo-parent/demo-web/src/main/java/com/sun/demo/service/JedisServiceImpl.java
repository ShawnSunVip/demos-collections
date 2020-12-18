package com.sun.demo.service;

import com.sun.demo.error.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * @author sunxiang
 * @date 2020-12-18 13:01
 **/
@Service
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String getRedisLock(String lockKey) {
        Long firstTime = System.currentTimeMillis();
        String lockValue =firstTime.toString();
        boolean lock = isLock(lockKey, lockValue);
        while (!lock){
            Long secondTime = System.currentTimeMillis();
            if((secondTime-firstTime)/1000 >15){
                System.out.println(Thread.currentThread().getName()+"加锁超时");
                throw  new BusinessException("加锁超时");
            }

            lock = isLock(lockKey,secondTime.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return lockValue;
    }

    private boolean isLock(String lockKey,String lockValue){
        Jedis jedis =jedisPool.getResource();
        try {
            if("OK".equals(jedis.set(lockKey,lockValue))){
                jedis.expire(lockKey,10);
                System.out.println(Thread.currentThread().getName()+"加锁成功");
                return true;
            }

            String value = jedis.get(lockKey);
            if(StringUtils.isNotEmpty(value)){
                Long currentTime = System.currentTimeMillis();
                Long interval = (currentTime - Long.parseLong(value)) / 1000;
                if(interval >15){
                    String oldValue = jedis.getSet(lockKey, lockValue);
                    if(StringUtils.isNotEmpty(oldValue) && oldValue.equals(lockValue)){
                        jedis.expire(lockKey,10);
                        System.out.println(Thread.currentThread().getName()+"续期加锁成功");
                        return true;
                    }
                }

            }


        } finally {
            jedis.close();
        }
        return false;
    }

    @Override
    public void unRedisLock(String lockKey, String lockValue) {
        Jedis jedis =jedisPool.getResource();
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            Object result = jedis.eval(script, Collections.singletonList(lockKey),
                    Collections.singletonList(lockValue));
            if("1".equals(result.toString())){
                System.out.println(Thread.currentThread().getName()+"解锁成功");
            }
        }finally {
            jedis.close();
        }
    }
}
