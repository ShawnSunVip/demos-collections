package com.sun.juc.pool;

import java.util.concurrent.*;

/**
 * @author shawn
 * @descript
 * CPU密集型也是指计算密集型，大部分时间用来做计算逻辑判断等CPU动作的程序称为CPU密集型任务。该类型的任务需要进行大量的计算，主要消耗CPU资源。
 *    最大线程数一般只需要设置为CPU核心数的线程个数
 * IO密集型任务指任务需要执行大量的IO操作，涉及到网络、磁盘IO操作，对CPU消耗较少，其消耗的主要资源为IO。
 *    1.CPU核心数两倍的线程
 *    2.CPU核数/1-阻塞系数   阻塞系数0.8~0.9
 * @create 2020-09-17 9:08 下午
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        System.out.println("系统："+Runtime.getRuntime().availableProcessors()+"核");

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                8,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //new ThreadPoolExecutor.AbortPolicy()  超出异常 RejectedExecutionException
        //new ThreadPoolExecutor.CallerRunsPolicy()  回退给调用者
        //new ThreadPoolExecutor.DiscardPolicy() 直接拒绝
        //new ThreadPoolExecutor.DiscardOldestPolicy() 将等待最久大释放，

        // 最大数量 =最大线程数+阻塞队列大长度
        try {
            for (int i = 1; i <=25 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 来了");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
