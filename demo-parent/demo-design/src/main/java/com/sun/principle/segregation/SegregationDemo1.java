package com.sun.principle.segregation;

/**
 * @author shawn
 * @descript 接口隔离原则
 * @create 2020-10-11 8:38 下午
 */
public class SegregationDemo1 {
    public static void main(String[] args) {
        // 写个demo 类A通过接口依赖类C 类B通过接口依赖类D
        // 以下方法不符合接口隔离原则
        A a = new A();
        B b = new B();
        a.do1(new C());
        a.do2(new C());
        a.do3(new C());
        b.do1(new D());
        b.do4(new D());
        b.do5(new D());
    }
}

// 定义接口 有方法1，2，3，4，5
interface Interface1{
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
}

// 类C实现接口
class C implements  Interface1{

    public void method1() {
        System.out.println("C 实现method1");
    }

    public void method2() {
        System.out.println("C 实现method2");
    }

    public void method3() {
        System.out.println("C 实现method3");
    }

    public void method4() {
        System.out.println("C 实现method4");
    }

    public void method5() {
        System.out.println("C 实现method5");
    }
}

// 类D实现接口
class D implements  Interface1 {

    public void method1() {
        System.out.println("D 实现method1");
    }

    public void method2() {
        System.out.println("D 实现method2");
    }

    public void method3() {
        System.out.println("D 实现method3");
    }

    public void method4() {
        System.out.println("D 实现method4");
    }

    public void method5() {
        System.out.println("D 实现method5");
    }
}

// 类A 依赖 C的方法1，2，3
class A {

    public void do1(Interface1 i) {
        i.method1();
    }

    public void do2(Interface1 i) {
        i.method2();
    }

    public void do3(Interface1 i) {
        i.method3();
    }


}

// 类B 依赖 D的方法1，4，5
class B {

    public void do1(Interface1 i) {
        i.method1();
    }

    public void do4(Interface1 i) {
        i.method4();
    }

    public void do5(Interface1 i) {
        i.method5();
    }
}