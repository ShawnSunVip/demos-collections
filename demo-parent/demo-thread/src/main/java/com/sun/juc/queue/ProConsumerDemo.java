package com.sun.juc.queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shawn
 * @descript 生产消费模式-传统模式
 * 题目：一个初始值为0变量，2个线程交替操作，一个加一个减1，来5轮
 * 方法：
 * 线程    控制   资源类
 * 判断    处理  通知
 * 防止虚拟唤醒机制
 * @create 2020-09-14 9:20 下午
 */
public class ProConsumerDemo {
    public static void main(String[] args) throws Exception {
        MyData myData = new MyData();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    myData.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    myData.less();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}

class MyData {
    private volatile int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() throws Exception {
        lock.lock();
        try {
            // 1.判断
            while (num != 0) {
                // 等待，不生产
                condition.await();
            }
            // 2.处理
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void less() throws Exception {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


