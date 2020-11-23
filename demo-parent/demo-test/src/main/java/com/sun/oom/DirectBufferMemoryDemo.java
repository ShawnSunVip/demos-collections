package com.sun.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author shawn
 * @descript 直接内存溢出
 * java.lang.OutOfMemoryError: Direct buffer memory
 * 写nio使用byteBuffer读取
 * ByteBuffer.allocate  分配jvm堆内存，gc管控范围内，速度慢
 * ByteBuffer.allocteDirect 分配本地内存，gc无法回收，速度快
 * <p>
 * 配置jvm -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * @create 2020-11-23 9:37 下午
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置maxDirectMemory:" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
