package com.sun.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shawn
 * @descript gc回收时间过长，超过98%时间用来gc回收并且回收不到2%大堆内存
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 配置jvm -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * @create 2020-11-23 9:24 下午
 */
public class GcOverheadLimitExceededDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("====i:" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
