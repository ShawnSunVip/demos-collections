package com.sun.juc.queue;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shawn
 * @descript 生产消费模式-阻塞队列
 * @create 2020-09-15 8:43 下午
 */
public class ProConsumerBlockQueueDemo {
    public static void main(String[] args) {
        MyNewData myNewData =new MyNewData(new SynchronousQueue<>());
        new Thread(() -> {
            try {
                myNewData.Produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            try {
                myNewData.Consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("5s后，暂停生产");
        System.out.println();
        System.out.println();
        myNewData.Stop();
    }
}

class MyNewData{
    private volatile boolean FLAG=true; // 生产消费开关
    private AtomicInteger atomicInteger =new AtomicInteger();

    BlockingQueue<String> blockingQueue =null;

    // 队列
    public MyNewData(BlockingQueue<String> blockingQueue){
        this.blockingQueue =blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void Produce() throws Exception{
        String data =null;
        boolean ret =false;
        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";
            ret=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (ret){
                System.out.println(Thread.currentThread().getName()+"\t 生产"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 生产"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 生产停止了");
    }

    public void Consumer() throws Exception{
        String result=null;
        while (FLAG){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            // 如果取不到数据
            if (null ==result || result.equalsIgnoreCase("")){
                FLAG =false;
                System.out.println(Thread.currentThread().getName()+"超时，消费停止");
                // 一定要return 不然会一直等待消费
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费"+result+"成功");
        }
    }

    public void Stop(){
        this.FLAG=false;
    }
}
