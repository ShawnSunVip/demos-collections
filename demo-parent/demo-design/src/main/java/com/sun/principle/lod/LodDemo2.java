package com.sun.principle.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shawn
 * @descript
 * @create 2020-10-14 9:11 下午
 */
public class LodDemo2 {
    public static void main(String[] args) {
        D1 d = new D1();
        d.printAll(new C1());
    }
}

class A1 {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class B1 {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class C1 {
    public List<A1> getAllA(){
        List<A1> as = new ArrayList<A1>();
        for (int i = 0; i <5 ; i++) {
            A1 a = new A1();
            a.setId(i);
            as.add(a);
        }
        return as;
    }

    public void printA(){
        List<A1> allA = getAllA();
        for (A1 a: allA) {
            System.out.println("A:"+a.getId());
        }
    }

}

class D1 {
    public List<B1> getAllB(){
        List<B1> bs = new ArrayList<B1>();
        for (int i = 0; i <10 ; i++) {
            B1 b = new B1();
            b.setId(i);
            bs.add(b);
        }
        return bs;
    }

    public void printAll(C1 c){
        c.printA();
        List<B1> allB = this.getAllB();
        for (B1 b: allB) {
            System.out.println("B:"+b.getId());
        }
    }
}
