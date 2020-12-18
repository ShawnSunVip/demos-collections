package com.sun.demo.controller;

import com.sun.demo.service.SimpleDistributedLockMutex;
import com.sun.demo.service.ZkClientExt;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

/**
 * @author sunxiang
 * @date 2020-12-18 16:36
 **/
public class ZKTestController {
    public static void main(String[] args) {
        final ZkClientExt zkClientExt1 = new ZkClientExt("47.103.96.71:2181", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex1 = new SimpleDistributedLockMutex(zkClientExt1, "/Mutex");

        final ZkClientExt zkClientExt2 = new ZkClientExt("47.103.96.71:2181", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex2 = new SimpleDistributedLockMutex(zkClientExt2, "/Mutex");

        try {
            mutex1.acquire();
            System.out.println("Client1 locked");
            Thread client2Thd = new Thread(new Runnable() {

                public void run() {
                    try {
                        mutex2.acquire();
                        System.out.println("Client2 locked1");
                        mutex2.release();
                        System.out.println("Client2 released lock1");
                        mutex2.acquire();
                        System.out.println("Client2 locked2");
                        mutex2.release();
                        System.out.println("Client2 released lock2");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            client2Thd.start();
            Thread.sleep(5000);
            mutex1.release();
            System.out.println("Client1 released lock");

            client2Thd.join();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
