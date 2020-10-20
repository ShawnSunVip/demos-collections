package com.sun.principle.singleresponsibility;

/**
 * @author shawn
 * @descript 单一职责原则ß
 * @create 2020-10-09 9:33 下午
 */
public class SingleDemo1 {
    public static void main(String[] args) {
        Animal vehicle =new Animal();
        vehicle.run("马");
        vehicle.run("鸟");
        vehicle.run("鱼");
    }
}

//动物类
//demo1
//1.run方法违反了单一职责原则
//2.解决思路，根据不同动物对运动方式，分解成不同类
class Animal {
    public void run(String vehicel) {
        System.out.println(vehicel+"\t 在公路上跑");
    }
}