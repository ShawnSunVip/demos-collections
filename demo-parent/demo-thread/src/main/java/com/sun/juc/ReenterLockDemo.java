package com.sun.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shawn
 * @descript 可重入锁
 * 概念：线程可以进入任何一个它已经拥有锁所同步的代码块
 * 包括：synchronized 和 Lock
 * 作用：避免死锁
 *
 * 扩展 sync和lock区别
 * 类别	    synchronized	                                                    Lock
 * 存在层次	Java的关键字，在jvm层面上	                                            是一个类
 * 锁的释放	1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁	在finally中必须释放锁，不然容易造成线程死锁
 * 锁的获取	假设A线程获得锁，B线程等待。如果A线程阻塞，B线程会一直等待	                分情况而定，Lock有多个锁获取的方式，大致就是可以尝试获得锁，线程可以不用一直等待
 * 锁状态	无法判断	                                                            可以判断
 * 锁类型	可重入 不可中断 非公平	                                                可重入 可判断 可公平（两者皆可）
 * 性能	    少量同步	                                                            大量同步
 * @create 2020-09-09 7:08 下午
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        SyncReenterLock();
        LockReenterLock();
    }

    /**
     * Lock重入锁
     */
    public static void LockReenterLock() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("第1次获取锁，这个锁是：" + lock);
                int index = 1;
                while (true) {
                    try {
                        lock.lock();
                        System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (index == 10) {
                            break;
                        }
                    } finally {
                        //获取几次锁就必须解锁几次，不然下面的线程获取不到新的锁
                        //注释掉下面代码则程序无法结束
                        lock.unlock();
                    }
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        // 测试上面线程不释放锁 能不能获取到锁
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "\t尝试获取锁:" + lock);
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    /**
     * synchronized可重入锁
     */
    public static void SyncReenterLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}


