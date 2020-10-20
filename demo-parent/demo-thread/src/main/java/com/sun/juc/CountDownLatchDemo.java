package com.sun.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript 计数器
 * @create 2020-09-10 8:50 下午
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        OverWork();

        Unify();
    }

    // 统一六国demo
    public static void Unify() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭！");
                countDownLatch.countDown();
            }, CountryEnum.forEach_Country(i).getName()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦统一六国！");
    }

    // 下班demo
    public static void OverWork() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t客人用餐完毕，离开饭店");
                    countDownLatch.await(2, TimeUnit.SECONDS);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t 员工可以下班了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
