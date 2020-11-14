package com.sun.factory;

/**
 * @author sunxiang
 * 乘法
 * @date 2020-11-13 12:06
 **/
public class OperationMul extends Operation {

    @Override
    public double getResult(){
        double result =0;
        result = getNumA()*getNumB();
        return result;
    }
}
