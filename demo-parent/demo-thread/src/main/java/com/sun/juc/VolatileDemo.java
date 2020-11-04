package com.sun.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shawn
 * @descript volatile是java虚拟机提供多轻量级的同步机制
 * 1.可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 * JMM（Java内存模型）
 * 1.可见性
 * 2.原子性
 * 3.有序性 （数据依赖性）
 * 源代码->编译器优化重排->指令并行重排->内存系统重排->最终执行的指令
 * @create 2020-09-06 5:20 下午
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //验证volatile的可见性
        System.out.println("验证volatile的可见性");
        //verifyVisibility();

        System.out.println("——————————————————————————————————————");

        System.out.println("验证原子性");
        //验证原子性
        //verifyAtomic();

        System.out.println("——————————————————————————————————————");

        System.out.println("验证禁止指令重排");
        verifyRearrangement();
    }

    /**
     * 验证volatile的可见性
     * 结论：添加volatile后，及时通知其他工作内存主内存值已被修改
     */
    public static void verifyVisibility() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t start");
            // 暂停线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNumTo10();
            System.out.println(Thread.currentThread().getName() + "\t update num value:" + myData.num);
        }, "A").start();

        while (myData.num == 0) {
            //main线程等待循环，直到num值不为0
            //1。如果不加volatile main线程会循环死
            //2。如果加了volatile 主内存把值回读给工作内存，跳出循环
        }
        System.out.println(Thread.currentThread().getName() + "\t main is over,num value:" + myData.num);
    }

    /**
     * 验证原子性
     * 结论：无法保证原子性
     * 解决方法：
     * 1。使用sync
     * 2。使用atomic
     */
    public static void verifyAtomic() {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    //1.不加任何，无法保证原子性 num<=20000
                    myData.addPlusNum();
                    //2.添加synchronized，保证原子性 num=20000
                    //myData.syncAddPlusNum();
                    //3.Atomic原子
                    myData.atomicAddPlusNum();
                }
            }, String.valueOf(i)).start();
        }

        //等待线程结束再看结果值
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t num value:" + myData.num + "\t atomicNum value:" + myData.atomicNum);
    }

    /**
     * 验证禁止指令重排
     */
    public static void verifyRearrangement() {
        MyData2 myData2 = new MyData2();
        for (int i = 1; i < 2000; i++) {
            new Thread(() -> {
                myData2.method01();
                myData2.method02();
            }, String.valueOf(i)).start();
        }
    }
}


class MyData {
    //int num = 0;
     int num = 0;

    AtomicInteger atomicNum = new AtomicInteger(0);

    public void addNumTo10() {
        this.num = 10;
    }

    public void addPlusNum() {
        num++;
    }

    public synchronized void syncAddPlusNum() {
        num++;
    }

    public void atomicAddPlusNum() {
        atomicNum.getAndIncrement();
    }
}

class MyData2 {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            a = a + 10;
            System.out.println("a:" + a);
        }
    }
}