package com.sun.principle.segregation;

/**
 * @author shawn
 * @descript 接口隔离原则
 * @create 2020-10-11 9:03 下午
 */
public class SegregationDemo2 {
    public static void main(String[] args) {
        // 改进
        A1 a = new A1();
        B1 b = new B1();
        a.do1(new C1());
        a.do2(new C1());
        a.do3(new C1());
        b.do1(new D1());
        b.do4(new D1());
        b.do5(new D1());
    }
}

// 定义接口11 有方法1
interface Interface11{
    void method1();
}

// 定义接口12 有方法2，3
interface Interface12{
    void method2();
    void method3();
}

// 定义接口13 有方法4，5
interface Interface13{
    void method4();
    void method5();
}

// 类C实现接口11和12
class C1 implements Interface11,Interface12{

    public void method1() {
        System.out.println("C 实现method1");
    }

    public void method2() {
        System.out.println("C 实现method2");
    }

    public void method3() {
        System.out.println("C 实现method3");
    }
}

// 类D实现接口11，13
class D1 implements  Interface11,Interface13 {

    public void method1() {
        System.out.println("D 实现method1");
    }

    public void method4() {
        System.out.println("D 实现method4");
    }

    public void method5() {
        System.out.println("D 实现method5");
    }
}

// 类A 依赖 C的方法1，2，3
class A1 {

    public void do1(Interface11 i) {
        i.method1();
    }

    public void do2(Interface12 i) {
        i.method2();
    }

    public void do3(Interface12 i) {
        i.method3();
    }


}

// 类B 依赖 D的方法1，4，5
class B1 {

    public void do1(Interface11 i) {
        i.method1();
    }

    public void do4(Interface13 i) {
        i.method4();
    }

    public void do5(Interface13 i) {
        i.method5();
    }
}
