package com.sun.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author shawn
 * @descript
 * @create 2020-09-13 7:54 下午
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 生产一个蛋糕1");
                blockingQueue.put("d1");
                System.out.println(Thread.currentThread().getName() + "\t 生产一个蛋糕2");
                blockingQueue.put("d2");
                System.out.println(Thread.currentThread().getName() + "\t 生产一个蛋糕3");
                blockingQueue.put("d3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 买走蛋糕1");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t 买走蛋糕2");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t 买走蛋糕3");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
