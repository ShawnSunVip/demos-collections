package com.sun.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript 死锁指两个或者两个以上进程执行中互相竞争资源造成互相等待
 * 怎么定位进程号？
 *   jps -l
 * 查看进程
 *   jstack  线程
 *
 * @create 2020-09-21 9:29 下午
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "LockB";

        new Thread(new HoldLockThread(lockA, lockB),"t1").start();
        new Thread(new HoldLockThread(lockB, lockA),"t2").start();

        /*
        "t2":
        at com.sun.juc.HoldLockThread.run(DeadLockDemo.java:45)
        - waiting to lock <0x000000076aca3000> (a java.lang.String)
        - locked <0x000000076aca3038> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)
        "t1":
        at com.sun.juc.HoldLockThread.run(DeadLockDemo.java:45)
        - waiting to lock <0x000000076aca3038> (a java.lang.String)
        - locked <0x000000076aca3000> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)
*/
    }
}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t有锁：" + lockA + "\t 尝试获取锁：" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t有锁：" + lockB + "\t 尝试获取锁：" + lockA);
            }
        }
    }
}

