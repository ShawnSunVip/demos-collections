package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——枚举
 * 优点：
 * 防多线程，防反序列化重写创建对象
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton07 instance01 = Singleton07.INSTANCE;
        Singleton07 instance02 = Singleton07.INSTANCE;
        System.out.println(instance01 == instance02);
    }
}

enum Singleton07{
    INSTANCE;
}
