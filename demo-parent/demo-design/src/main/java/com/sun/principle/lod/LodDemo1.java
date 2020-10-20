package com.sun.principle.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shawn
 * @descript 迪米特原则
 * @create 2020-10-14 8:55 下午
 */
public class LodDemo1 {
    public static void main(String[] args) {
        D d = new D();
        d.printAll(new C());
    }
}

class A {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class B {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class C {
    public List<A> getAllA(){
        List<A> as = new ArrayList<A>();
        for (int i = 0; i <5 ; i++) {
            A a = new A();
            a.setId(i);
            as.add(a);
        }
        return as;
    }
}

class D {
    public List<B> getAllB(){
        List<B> bs = new ArrayList<B>();
        for (int i = 0; i <10 ; i++) {
            B b = new B();
            b.setId(i);
            bs.add(b);
        }
        return bs;
    }

    public void printAll(C c){
        List<A> allA = c.getAllA();
        for (A a: allA) {
            System.out.println("A:"+a.getId());
        }
        List<B> allB = this.getAllB();
        for (B b: allB) {
            System.out.println("B:"+b.getId());
        }
    }
}

