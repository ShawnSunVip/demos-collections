package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——懒汉式  线程不安全
 * 优点：
 * 调用的时候才去实例化，节省内存
 * 缺点：
 * 多线程不安全
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton03 sigleton01=Singleton03.getInstance();
        Singleton03 sigleton02=Singleton03.getInstance();
        System.out.println(sigleton01==sigleton02);
    }
}

class Singleton03{
    private Singleton03(){}

    private static Singleton03 instance;

    public static Singleton03 getInstance(){
        if(instance ==null){
            instance = new Singleton03();
        }
        return instance;
    }
}
