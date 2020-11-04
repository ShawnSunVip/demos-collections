package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——懒汉式 静态内部类
 * 优点：
 * 线程安全，效率高
 * 类装载机制
 * 静态内部类被装载时不会立即实例化，被调用时才会。
 * 类静态属性只会在类第一次加载时初始化，jvm保证线程的安全性
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton06 sigleton01=Singleton06.getInstance();
        Singleton06 sigleton02=Singleton06.getInstance();
        System.out.println(sigleton01 == sigleton02);
    }
}

class Singleton06{
    private Singleton06(){}

    private static class Singleton06Instance{
        private static final Singleton06 INSTANCE=new Singleton06();
    }

    public static  Singleton06 getInstance(){
        return Singleton06Instance.INSTANCE;
    }
}
