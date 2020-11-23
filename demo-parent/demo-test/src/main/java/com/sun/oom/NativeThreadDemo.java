package com.sun.oom;

import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript 不能创建新堆本地线程
 * 一个应用进程创建多个线程
 * @create 2020-11-23 9:50 下午
 */
public class NativeThreadDemo {
    public static void main(String[] args) {
        while (true) {
            int i = 1;
            new Thread(() -> {
                try {
                    TimeUnit.HOURS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i++)).start();
        }
    }
}
