package com.sun.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript 阻塞队列
 * Collection
 *  - List
 *  - Queue
 *     -BlockQueue
 *        -ArrayBlockingQueue  *数组有界阻塞队列
 *        -LinkBlockingQueue   *链表有界阻塞队列（默认大小Interger.MAX_VALUE）
 *        -PriorityBlockingQueue 优先级排序无界阻塞队列
 *        -DelayQueue            优先级延迟无界阻塞队列
 *        -SynchronousQueue    *单个元素队列
 *        -LinkedTransferQueue  链表无界阻塞队列
 *        -LinkedBlockingDeque  链表双向阻塞队列
 *
 *  方法类型    抛出异常    特殊值      阻塞     超时
 *  插入       add(e)   offer(e)    put(e)   offer(e,time,unit)
 *  移除      remove()   poll()      take()   poll(time,unit)
 *  检查      element()  peek()      不可用    不可用
 * @create 2020-09-11 9:20 下午
 */
public class BlockQueueDemo {
    public static void main(String[] args) throws Exception {
        //Test01();
        //Test02();
        Test03();

    }

    // 带失效日前offer(e,time,unit)   poll(time,unit)
    public static void Test03() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2L, TimeUnit.SECONDS));
        // 插入队列已满阻塞2s后 返回插入结果 false
        System.out.println(blockingQueue.offer("d",2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        // 移除，队列已空，阻塞2s后 返回移除结果 null
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    }

    // put()  take()
    public static void Test02() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 队列满时候，生产者继续put()会阻塞线程
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        System.out.println("============");
        blockingQueue.put("d");

        //队列为空时，消费者take()会阻塞队列
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    // 测试add() off() remove() poll() element() peek()
    public static void Test01() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println("再插入一个元素会怎么样？");
        // 返回false
        //System.out.println(blockingQueue.offer("d"));
        // 报错：java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println("再移除一个元素会怎么样？");
        // 返回 null
        //System.out.println(blockingQueue.poll());
        // 报错：java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

        System.out.println("检索不到会怎么样？");
        // 报错：java.util.NoSuchElementException
        //System.out.println("检索当前元素是："+blockingQueue.element());
        // 返回 null
        //System.out.println("检索当前元素是："+blockingQueue.peek());
    }
}
