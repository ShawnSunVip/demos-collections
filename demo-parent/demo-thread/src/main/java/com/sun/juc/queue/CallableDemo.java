package com.sun.juc.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript
 * Callable的用法
 * Callable和Runnable区别
 * 1。实现Callable接口的任务线程能返回执行结果，而实现Runnable接口的任务线程不能返回执行结果
 * 2。Callable接口实现类中run()方法允许将异常向上抛出，也可以直接在内部处理(try...catch); 而Runnable接口实现类中run()方法的异常必须在内部处理掉，不能向上抛出
 * @create 2020-09-15 9:16 下午
 */
public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*Thread t1=new Thread(new MyThread());
        t1.start();*/

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "t2").start();
        // 这样会有什么效果？Callable执行几次？结果如何？
        new Thread(futureTask, "t3").start();

        //试试放上面会有什么效果？？？ main线程被阻塞！！！
        //int result02=futureTask.get();
        int result01 = 222;
        System.out.println(Thread.currentThread().getName() + "\t result:" + result01);

        while (!futureTask.isDone()){
            //System.out.println("等待。。");
        }

        //要求获取callable的计算结果，如果没有计算完成则阻塞直到计算完成，一般放最后
        int result02 = futureTask.get();
        System.out.println("result:" + (result01 + result02));

    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\tcome in");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 444;
    }
}
