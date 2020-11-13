package com.sun.factory;

/**
 * @author sunxiang
 * @date 2020-11-13 12:06
 **/
public class OperationSum extends Operation {

    @Override
    public double getResult(){
        double result =0;
        result = getNumA()+getNumB();
        return result;
    }
}
