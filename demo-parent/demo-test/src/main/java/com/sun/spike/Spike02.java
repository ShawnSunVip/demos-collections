package com.sun.spike;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 秒杀案例——中级
 * 解决超卖
 * 存在库存遗留问题
 * @author sunxiang
 * @date 2021-01-22 12:47
 **/
public class Spike02 {

    public static boolean doSpike(String uId,String prodId){
        // redis连接
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.auth("123456");

        // 库存和商品购买人
        String kcKey ="spike/"+prodId+"/kc";
        String userKey ="spike/"+prodId+"/user";

        // 添加监视
        jedis.watch(kcKey);
        //秒杀未开始 库存为null
        //set spike/0001/kc 10
        String kc = jedis.get(kcKey);
        if(kc ==null){
            System.out.println("秒杀未开始");
            jedis.close();
            return false;
        }

        // 已秒杀
        if(jedis.sismember(userKey,uId)){
            System.out.println(Thread.currentThread().getName()+"已秒杀，无法重复秒杀");
            jedis.close();
            return false;
        }

        // 库存不足，秒杀结束
        if(Integer.parseInt(kc)<0){
            System.out.println("秒杀结束");
            jedis.close();
            return false;
        }

        // 事务
        Transaction multi = jedis.multi();
        // 减库存 添加人
        multi.decr(kcKey);
        multi.sadd(userKey,uId);
        List<Object> exec = multi.exec();
        if(exec ==null || exec.size() == 0){
            System.out.println(Thread.currentThread().getName()+"秒杀失败");
            jedis.close();
            return false;
        }
        System.out.println(Thread.currentThread().getName()+"秒杀成功");
        jedis.close();
        return true;
    }

    public static String getKcNum(String prodId){
        // redis连接
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        String kcKey ="spike/"+prodId+"/kc";

        String kc = jedis.get(kcKey);
        return kc;
    }

    public static void main(String[] args) throws InterruptedException{
        //boolean b = doSpike(UUID.randomUUID().toString(), "0001");
        String prodId="0001";
        for (int i = 1; i <=50 ; i++) {
            new Thread(() -> {
                try{TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
                doSpike(UUID.randomUUID().toString(), prodId);
            }, String.valueOf(i)).start();
        }

        try{TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("最终库存："+getKcNum(prodId));
    }
}
