package com.sun.juc;

import java.util.*;

/**
 * @author shawn
 * @descript 集合类的不安全
 * ArrayList HashMap HashSet
 * @create 2020-09-08 8:51 下午
 */
public class CollectionsNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1.错误
         *    java.util.ConcurrentModificationException
         * 2.原因
         *   并发导致，同时写入导致数据不一致，保并发修改异常
         * 3.解决方案
         *    1)List<String> list = new Vector()  下下策，加了sync锁
         *    2)List<String> list = Collections.synchronizedList(new ArrayList<>()); 使用Collections工具类
         *    3)List<String> list = new CopyOnWriteArrayList<>();  使用JUC的方法，private transient volatile Object[] array;
         * 4.优化建议
         */

        /**
         * CopyOnWriteArrayList 源码  写时复制
         *
         * public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             获取数组的值
         *             Object[] elements = getArray();
         *             获取数组长度
         *             int len = elements.length;
         *             新建一个数组长度+1的新数组
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             赋值到新数组最后一个位置
         *             newElements[len] = e;
         *             写回数组
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         */

        /**
         * 扩展 sync和lock区别
         * 类别	    synchronized	                                                    Lock
         * 存在层次	Java的关键字，在jvm层面上	                                            是一个类
         * 锁的释放	1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁	在finally中必须释放锁，不然容易造成线程死锁
         * 锁的获取	假设A线程获得锁，B线程等待。如果A线程阻塞，B线程会一直等待	                分情况而定，Lock有多个锁获取的方式，大致就是可以尝试获得锁，线程可以不用一直等待
         * 锁状态	无法判断	                                                            可以判断
         * 锁类型	可重入 不可中断 非公平	                                                可重入 可判断 可公平（两者皆可）
         * 性能	    少量同步	                                                            大量同步
         */
    }
}
