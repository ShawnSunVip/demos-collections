package com.sun.factory;

/**
 * @author sunxiang
 * 计数工厂
 * @date 2020-11-13 12:00
 **/
public class OperationFactory {
    public static Operation createOperation(String operation){
        Operation oper=null;
        switch (operation){
            case "+" : oper = new OperationSum(); break;
            case "-" : oper = new OperationSub(); break;
            case "*" : oper = new OperationMul(); break;
            case "/" : oper = new OperationDiv(); break;
        }
        return oper;
    }
}
