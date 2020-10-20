package com.sun.principle.richterreplace;

/**
 * @author shawn
 * @descript
 * @create 2020-10-13 9:38 下午
 */
public class RichterReplaceDemo2 {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("8+1:"+a.method(8, 1));

        B1 b = new B1();
        System.out.println("8-1:"+b.method(8,1));
    }
}

//添加一个更基础但基类
class Base {

}

class A1 extends Base {
    public int method(int n1,int n2){
        return n1+n2;
    }
}

// B类不在继承A，调用功能很明确，调用者不会改错
class B1 extends Base {
    public int method(int n1,int n2){
        return n1-n2;
    }

    public int method2(int n1,int n2) {
        return (n1+n2)*3;
    }
}
