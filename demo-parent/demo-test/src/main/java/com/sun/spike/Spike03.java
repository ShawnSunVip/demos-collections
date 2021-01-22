package com.sun.spike;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 秒杀案例——高级
 * 解决超卖和遗留
 * @author sunxiang
 * @date 2021-01-22 12:47
 **/
public class Spike03 {

    private static String script="local userid=KEYS[1];\n" +
            "local prodid=KEYS[2];\n" +
            "local kckey='spike/'..prodid..'/kc';\n" +
            "local userkey='spike/'..prodid..'/user';\n" +
            "local userExists=redis.call(\"sismember\",userkey,userid);\n" +
            "if tonumber(userExists)==1 then\n" +
            "    return 2;\n" +
            "end\n" +
            "local num =redis.call('get',kckey);\n" +
            "if tonumber(num)<0 then\n" +
            "    return 0;\n" +
            "else\n" +
            "    redis.call('decr',kckey);\n" +
            "    redis.call('sadd',userkey,userid);\n" +
            "end\n" +
            "return 1;";

    public static boolean doSpike(String uId,String prodId){
        // redis连接
        JedisPool jedisPool = JedisPoolUtils.getInstance();
        Jedis jedis = jedisPool.getResource();
        String sha = jedis.scriptLoad(script);
        Object evalsha = jedis.evalsha(sha,2,uId,prodId);
        String str=String.valueOf(evalsha);
        if("0".equals(str)){
            System.out.println("已抢空");
        }else if("1".equals(str)){
            System.out.println(Thread.currentThread().getName()+"秒杀成功");
        }else if("2".equals(str)){
            System.out.println(Thread.currentThread().getName()+"已秒杀过");
        }
        jedisPool.close();
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
        String prodId="0001";
        //boolean b = doSpike(UUID.randomUUID().toString(), "0001");
        for (int i = 1; i <=1000 ; i++) {
            new Thread(() -> {
                //try{TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
                doSpike(UUID.randomUUID().toString(), prodId);
            }, String.valueOf(i)).start();
        }

        try{TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("最终库存："+getKcNum(prodId));
    }
}
