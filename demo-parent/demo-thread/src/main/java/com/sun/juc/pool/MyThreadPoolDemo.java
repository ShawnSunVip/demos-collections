package com.sun.juc.pool;

import java.util.concurrent.*;

/**
 * @author shawn
 * @descript 线程池
 * newScheduledTHreadPool()
 * newWorkStealingPool(int)
 * newFixedThreadPool(int)   一池多线程 LinkedBlockingQueue  执行长期任务
 * newSingleThreadExecutor() 一池单线程 LinkedBlockingQueue  一个一个任务执行
 * newCachedThreadPool()   一池带缓存  SynchronousQueue  短期异步小程序或负载轻服务器
 *
 * 7大参数
 * corePoolSize  核心线程数
 * maximumPoolSize  最大线程数
 * keepAliveTime  多余线程存活日期
 * unit  单位
 * workQueue  阻塞队列
 * ThreadFactory  线程工厂
 * RejectedExcutionHandler   拒绝策略
 *
 * 4大拒绝策略
 * CallerRunsPolicy 回退给调用者
 * AbortPolicy （默认） 抛出异常并阻止系统运行
 * DiscardPolicy   直接丢任务
 * DiscardOldestPolicy  丢等待最久任务
 * @create 2020-09-17 8:15 下午
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("系统："+Runtime.getRuntime().availableProcessors()+"核");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        //ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i <= 10; i++) {
                executor.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t进来吃饭");
                });
                //newCachedThreadPool 随机扩容
                //try {TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


    /*public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        // 如果当前任务少于核心线程数，创建核心线程
        int c = ctl.get();
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))
                return;
            c = ctl.get();
        }
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false);
        }
        else if (!addWorker(command, false))
            reject(command);
    }*/
