package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式—— 懒汉式 线程安全synchronized
 * 优点：
 * 线程安全了
 * 缺点：
 * 同步效率太低
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton04 sigleton01=Singleton04.getInstance();
        Singleton04 sigleton02=Singleton04.getInstance();
        System.out.println(sigleton01==sigleton02);
    }
}

class Singleton04{
    private Singleton04(){}

    private static Singleton04 instance;

    public static synchronized Singleton04 getInstance(){
        if(instance ==null){
            instance = new Singleton04();
        }
        return instance;
    }
}
