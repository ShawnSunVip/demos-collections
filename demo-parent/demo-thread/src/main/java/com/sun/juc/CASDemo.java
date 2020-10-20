package com.sun.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shawn
 * @descript CAS ===>   compareAndSwap CPU底层并发原语
 * 缺陷：1。循环时间长开销大
 * 2。只能保证一个变量对原子性
 * 3。ABA问题
 * @create 2020-09-07 7:31 下午
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // 比较并交换 期望值等于内存地址偏移量则替换否则返回false
        System.out.println(atomicInteger.compareAndSet(5, 4) + "\t current value:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1) + "\t current value:" + atomicInteger.get());
    }
// CAS
//    AtomicInteger源码代码段
//    unsafe=>底层汇编指令，对内存直接操作，操作连续
//    private static final Unsafe unsafe = Unsafe.getUnsafe();
//    内存偏移量地址
//    private static final long valueOffset;
//
//    static {
//        try {
//            valueOffset = unsafe.objectFieldOffset
//                    (AtomicInteger.class.getDeclaredField("value"));
//        } catch (Exception ex) { throw new Error(ex); }
//    }
//    保证可见性
//    private volatile int value;
//
//    unsafe源码代码段
//    自旋锁
//    判断期望值和内存地址偏移量值是否相等，不等则继续取内存地址偏移量值，直到比较相等则替换成新值
//    public final int getAndSetInt(Object var1, long var2, int var4) {
//        int var5;
//        do {
//            根据当前对象和内存地址偏移量获取内存值
//            var5 = this.getIntVolatile(var1, var2);
//        } while(!this.compareAndSwapInt(var1, var2, var5, var4));
//        循环比较内存的值是否等于期望值，相等则替换成新值，否则重新获取当前对象内存值直到等于期望值
//        return var5;
//    }

}
