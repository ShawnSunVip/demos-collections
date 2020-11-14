package com.sun.factory;

/**
 * @author sunxiang
 * 工厂模式
 * 实例：设计计算器
 * 思路：
 * 根据算法符号得到相应的算法对象
 * 算法对象放到一个工厂类中去维护创建
 * 使业务逻辑和页面逻辑分开，松耦合
 * 实现：
 * 1。定义一个基础操作类Operation，封装输入的数字和返回的结果方法
 * 2。定义加减乘除操作类继承基础操作类，并重写里面的返回结果方法
 * 3。定义一个工厂类，定义一个静态的createOperation，根据入参来判断实例化哪个操作类，返回基础类型
 *
 * @date 2020-11-13 12:11
 **/
public class FactoryTest {
    public static void main(String[] args) throws  Exception {
        Operation oper =OperationFactory.createOperation("/");
        oper.setNumA(12);
        oper.setNumB(14);
        double result = oper.getResult();
        System.out.println(result);
    }
}
