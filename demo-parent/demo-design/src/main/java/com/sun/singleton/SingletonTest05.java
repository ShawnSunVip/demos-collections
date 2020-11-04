package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——懒汉式  双端检锁机制
 * 优点
 * 线程安全 效率高
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton05 sigleton01=Singleton05.getInstance();
        Singleton05 sigleton02=Singleton05.getInstance();
        System.out.println(sigleton01==sigleton02);
    }
}

class Singleton05{
    private Singleton05(){}

    private volatile static Singleton05 instance;

    public static  Singleton05 getInstance(){
        if(instance ==null){
            synchronized (Singleton05.class){
                if(instance ==null){
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
