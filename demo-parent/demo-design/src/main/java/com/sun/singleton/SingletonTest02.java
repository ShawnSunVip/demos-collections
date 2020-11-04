package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——饿汉式静态代码块
 * 优缺点 同上
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton02 sigleton01=Singleton02.getInstance();
        Singleton02 sigleton02=Singleton02.getInstance();
        System.out.println(sigleton01==sigleton02);
    }
}

class Singleton02{
    private Singleton02(){}

    private static Singleton02 instance;

    // 静态代码块 创建实例
    static {
        instance=new Singleton02();
    }

    public static Singleton02 getInstance(){
        return instance;
    }
}
