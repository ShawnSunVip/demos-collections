package com.sun.principle.composite;

/**
 * @author shawn
 * @descript
 * @create 2020-10-14 9:32 下午
 */
public class CompositeDemo2 {
    public static void main(String[] args) {
        B1 b1 = new B1();
        // 解决方法1 依赖
        b1.method3(new A1());

        //解决方法2  聚合
        b1.setA(new A1());
        b1.method4();

        //解决方法2  组合
        b1.method5();

    }
}

class A1 {
    public void method1(){
        System.out.println("A:method1");
    }

    public void method2(){
        System.out.println("A:method2");
    }
}

class B1 {
    // 解决方法一
    public void method3(A1 a){
       a.method1();
    }

    // 解决方法二
    private A1 a;

    public A1 getA() {
        return a;
    }

    public void setA(A1 a) {
        this.a = a;
    }

    public void method4(){
        a.method1();
    }

    // 解决方法3
    private A1 a1 = new A1();
    public void method5(){
        a1.method1();
    }
}
