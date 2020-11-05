package com.sun.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shawn
 * @descript
 * Hashmap的自动扩容
 * 初始值
 * capacity : 16  数组长度
 * size : 12    当前元素
 * threshold : 12  临界值  数组长度*负载因子
 * loadFactor : 0.75  负载因子
 *
 * 扩展：为什么负载因子不是0.5或者1
 * 如果是0.5，临界值是8 则很容易就触发扩容，而且还有一半容量还没用
 * 如果是1，当空间被占满时候才扩容，增加插入数据的时间
 * 0.75即3/4，capacity值是2的幂，相乘得到结果是整数
 *
 *
 * 
 * @create 2020-10-21 10:44 下午
 */
public class HashMapTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        System.out.println(3541841 & (32-1));

        Map<String, String> map = new HashMap<>();
        map.put("sun1", "shawn");
        map.put("sun2", "shawn");
        map.put("sun3", "shawn");
        map.put("sun4", "shawn");
        map.put("sun5", "shawn");
        map.put("sun6", "shawn");
        map.put("sun7", "shawn");
        map.put("sun8", "shawn");
        map.put("sun9", "shawn");
        map.put("sun10", "shawn");
        map.put("sun11", "shawn");
        map.put("sun12", "shawn");
        Class<?> mapType = map.getClass();

        Method capacity1 = mapType.getDeclaredMethod("capacity");
        capacity1.setAccessible(true);
        System.out.println("capacity : " + capacity1.invoke(map));

        Field size1 = mapType.getDeclaredField("size");
        size1.setAccessible(true);
        System.out.println("size : " + size1.get(map));

        Field threshold1 = mapType.getDeclaredField("threshold");
        threshold1.setAccessible(true);
        System.out.println("threshold : " + threshold1.get(map));

        Field loadFactor1 = mapType.getDeclaredField("loadFactor");
        loadFactor1.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor1.get(map));

        map.put("sun13", "shawn");
        Method capacity2 = mapType.getDeclaredMethod("capacity");
        capacity2.setAccessible(true);
        System.out.println("capacity : " + capacity2.invoke(map));

        Field size2 = mapType.getDeclaredField("size");
        size2.setAccessible(true);
        System.out.println("size : " + size2.get(map));

        Field threshold2 = mapType.getDeclaredField("threshold");
        threshold2.setAccessible(true);
        System.out.println("threshold : " + threshold2.get(map));

        Field loadFactor2 = mapType.getDeclaredField("loadFactor");
        loadFactor2.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor2.get(map));

    }



}
