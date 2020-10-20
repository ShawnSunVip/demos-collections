package com.sun.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shawn
 * @descript
 * 题目：多线程之间按照顺序调用，实现A->B->C顺序
 * A打印5次，B打印10次，C打印15次
 * ...
 * 来3轮
 * @create 2020-09-14 9:20 下午
 */
public class ReentrantLockTopicDemo {
    public static void main(String[] args) {
        MyNewData myNewData = new MyNewData();
        new Thread(() -> {
            for (int i=1;i<=3;i++){
                myNewData.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i=1;i<=3;i++){
                myNewData.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i=1;i<=3;i++){
                myNewData.print15();
            }
        }, "C").start();
    }
}

class MyNewData{
    private int num =1;
    private Lock lock =new ReentrantLock();
    private Condition a=lock.newCondition();
    private Condition b=lock.newCondition();
    private Condition c=lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            // 1.判断
            while (num !=1){
                a.await();
            }
            // 2.处理
            for (int i=0;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 3.通知
            num =2;
            b.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            // 1.判断
            while (num !=2){
                b.await();
            }
            // 2.处理
            for (int i=0;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 3.通知
            num=3;
            c.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            // 1.判断
            while (num !=3){
                c.await();
            }
            // 2.处理
            for (int i=0;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 3.通知
            num=1;
            a.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
