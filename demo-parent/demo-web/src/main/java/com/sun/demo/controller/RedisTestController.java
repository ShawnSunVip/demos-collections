package com.sun.demo.controller;

import com.sun.demo.service.JedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author sunxiang
 * @date 2020-12-18 9:40
 **/
@RestController
public class RedisTestController {

    @Resource
    private JedisService jedisService;

    @RequestMapping("/insert")
    public void insertRedis(){
        new Thread(() -> {
            String lockValue = jedisService.getRedisLock("sun");
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(StringUtils.isNotEmpty(lockValue)){
                jedisService.unRedisLock("sun",lockValue);
            }
        }, "A").start();

        new Thread(() -> {
            String lockValue = jedisService.getRedisLock("sun");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(StringUtils.isNotEmpty(lockValue)){
                jedisService.unRedisLock("sun",lockValue);
            }
        }, "B").start();
    }
}
