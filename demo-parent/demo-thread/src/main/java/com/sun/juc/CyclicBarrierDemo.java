package com.sun.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shawn
 * @descript 收集器
 * @create 2020-09-10 8:51 下午
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("\t 召唤神龙！！！");
        });
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println("龙珠" + Thread.currentThread().getName() + "\t 被集齐");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }


    }
}
