package com.sun.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author shawn
 * @descript CAS之ABA问题解决
 * @create 2020-09-07 8:16 下午
 */
public class ABADemo {
    //原子引用
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(1);
    //带版本号的原子引用
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

    public static void main(String[] args) {

        // 1>2>1
        new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(1, 2) + "\t current value:" + atomicReference.get());
            System.out.println(atomicReference.compareAndSet(2, 1) + "\t current value:" + atomicReference.get());
        }, "A").start();

        // 1>5
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(1, 5) + "\t current value:" + atomicReference.get());
        }, "B").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============解决ABA问题=============");
        // 1>2>1
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);
            atomicStampedReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第二次版本号" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第三次版本号" + atomicStampedReference.getStamp());
        }, "C").start();
        //1>5
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);
            boolean flag = atomicStampedReference.compareAndSet(1, 5, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改结果:" + flag + "\t 当前版本号：" + atomicStampedReference.getStamp());
        }, "D").start();
    }
}
