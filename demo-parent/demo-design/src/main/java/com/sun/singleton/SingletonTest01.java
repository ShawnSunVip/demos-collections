package com.sun.singleton;

/**
 * @author shawn
 * @descript
 * 单例模式——饿汉式静态常量
 * 优点：
 * 类装载就实例化，避免线程同步
 * 缺点：
 * 如果一直没被用过，会导致内存浪费
 *
 * @create 2020-11-04 8:56 下午
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Sigleton01 sigleton01=Sigleton01.getInstance();
        Sigleton01 sigleton02=Sigleton01.getInstance();
        System.out.println(sigleton01==sigleton02);
    }

}

class Sigleton01 {
    // 私有构造器 防止被new对象
    private Sigleton01(){}

    // 内部创建对象
    private final static Sigleton01 instance =new Sigleton01();

    // 对外暴露静态公共方法
    public static Sigleton01 getInstance(){
        return instance;
    }
}
