package com.sun.principle.singleresponsibility;

/**
 * @author shawn
 * @descript 单一职责原则
 * @create 2020-10-09 9:52 下午
 */
public class SingleDemo3 {
    public static void main(String[] args) {
        NewAnimal newAnimal = new NewAnimal();
        newAnimal.run("马");
        newAnimal.runWater("鱼");
        newAnimal.runAir("鸟");
    }
}

//demo3
//1.只是在原来方法上添加方法
//2.在类上没有遵守单一职责原则，但在方法上，仍然遵守单一职责原则
class NewAnimal {
    public void run(String vehicel) {
        System.out.println(vehicel+"\t 在公路上跑");
    }
    public void runWater(String vehicel) {
        System.out.println(vehicel+"\t 在水里游");
    }
    public void runAir(String vehicel) {
        System.out.println(vehicel+"\t 在天上飞");
    }
}
