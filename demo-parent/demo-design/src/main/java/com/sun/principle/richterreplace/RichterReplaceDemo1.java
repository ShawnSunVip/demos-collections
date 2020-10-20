package com.sun.principle.richterreplace;

/**
 * @author shawn
 * @descript 里氏替换原则
 * @create 2020-10-13 9:31 下午
 */
public class RichterReplaceDemo1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("8+1:"+a.method(8, 1));

        B b = new B();
        System.out.println("8+1:"+b.method(8,1));


    }
}

class A {
    public int method(int n1,int n2){
        return n1+n2;
    }
}

class B extends A {
    // 不小心重写父类方法
    public int method(int n1,int n2){
        return n1-n2;
    }

    public int method2(int n1,int n2) {
        return (n1+n2)*3;
    }
}
