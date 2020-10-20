package com.sun.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shawn
 * @descript 读写锁
 * 模拟缓存读写操作
 * @create 2020-09-09 10:06 下午
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i < 5; i++) {
            final int temInt = i;
            new Thread(() -> {
                myCache.write(temInt + "", temInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i < 5; i++) {
            final int temInt = i;
            new Thread(() -> {
                myCache.read(temInt + "");
            }, String.valueOf(i)).start();
        }
    }
}

//缓存
class MyCache {
    // 保证可见性
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t start write");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t end write");
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object read(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t start read");
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t end read");
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }
}
