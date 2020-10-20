package com.sun.principle.singleresponsibility;

/**
 * @author shawn
 * @descript 单一职责原则
 * @create 2020-10-09 9:48 下午
 */
public class SingleDemo2 {
    public static void main(String[] args) {
        RoadAnimal roadAnimal = new RoadAnimal();
        roadAnimal.run("马");

        WaterAnimal waterAnimal = new WaterAnimal();
        waterAnimal.run("鱼");

        AirAnimal airAnimal = new AirAnimal();
        roadAnimal.run("鸟");

    }
}

//demo2
//1.遵守了单一职责原则
//2.改动很大，类分解
//3.还可以怎么改？
class RoadAnimal {
    public void run(String vehicel) {
        System.out.println(vehicel+"\t 在公路上跑");
    }
}
class WaterAnimal {
    public void run(String vehicel) {
        System.out.println(vehicel+"\t 在水里游");
    }
}
class AirAnimal {
    public void run(String vehicel) {
        System.out.println(vehicel+"\t 在天上飞");
    }
}


