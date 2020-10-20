package com.sun.juc;

/**
 * @author shawn
 * @descript
 * DCL双端检锁机制
 * @create 2020-09-06 8:47 下午
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 这是构造方法");
    }

    //单线程
    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    //DCL Double Check Lock 双端检锁机制
    //不安全，因为存在指令重排，加入volatile来禁止指令重排
    public static SingletonDemo getInstance2() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println("这是单线程。。。。。");
//        System.out.println(SingletonDemo.getInstance() ==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() ==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() ==SingletonDemo.getInstance());

        System.out.println("————————————————————————————————————————");

//        System.out.println("这是多线程。。。。。");
//        for (int i=1;i<10;i++)
//        {
//            new Thread(() -> {
//                SingletonDemo.getInstance();
//            }, String.valueOf(i)).start();
//        }

        System.out.println("————————————————————————————————————————");

        System.out.println("这是DCL多线程。。。。。");

        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance2();
            }, String.valueOf(i)).start();
        }


    }

}
