package com.sun.juc;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript
 * @create 2020-09-10 8:51 下午
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 号车进来了");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3s后离开");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
