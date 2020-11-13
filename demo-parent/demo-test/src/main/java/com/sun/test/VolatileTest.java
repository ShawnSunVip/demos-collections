package com.sun.test;

import java.util.concurrent.TimeUnit;

/**
 * @author sunxiang
 * @date 2020-11-05 19:22
 **/
public class VolatileTest {
    public static void main(String[] args) {
        System.out.println("验证volatile的可见性");
        test1();
    }

    public static void test1(){
        A myData = new A();
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

}

class A {
    int num =0;
    public void addNumTo10() {
        this.num = 10;
    }

}
