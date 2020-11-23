package com.sun.oom;

/**
 * @author shawn
 * @descript
 * 堆内存不足 java.lang.OutOfMemoryError: Java heap space
 *
 * 配置jvm -Xms10m -Xmx10m
 * @create 2020-11-23 9:03 下午
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        // 方法一 不断new对象
        /*String str="speas";
        while (true){
            str += str+ new Random().nextInt(111111111)+new Random().nextInt(222222222);
            str.intern();
        }*/

        // 方法二 大对象
        byte[] bytes =new byte[20*1024*1024];
    }
}
