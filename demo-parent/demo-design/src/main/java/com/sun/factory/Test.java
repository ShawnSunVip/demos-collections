package com.sun.factory;

/**
 * @author sunxiang
 * 工厂模式——设计计算器
 * 
 *
 * @date 2020-11-13 12:11
 **/
public class Test {
    public static void main(String[] args) throws  Exception {
        Operation oper =OperationFactory.createOperation("/");
        oper.setNumA(12);
        oper.setNumB(14);
        double result = oper.getResult();
        System.out.println(result);
    }
}
