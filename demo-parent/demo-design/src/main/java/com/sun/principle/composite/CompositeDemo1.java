package com.sun.principle.composite;

/**
 * @author shawn
 * @descript 合成复用原则
 * @create 2020-10-14 9:25 下午
 */
public class CompositeDemo1 {
    public static void main(String[] args) {
        B b = new B();
        b.method3();
    }
}

class A {
    public void method1(){
        System.out.println("A:method1");
    }

    public void method2(){
        System.out.println("A:method2");
    }
}

class B extends A {
    public void method3(){
        method1();
    }
}
