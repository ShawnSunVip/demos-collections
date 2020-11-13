package com.sun.factory;

/**
 * @author sunxiang
 * @date 2020-11-13 12:06
 **/
public class OperationDiv extends Operation {

    @Override
    public double getResult() throws Exception {
        double result =0;
        if(getNumB() ==0){
            throw new Exception("除数不能为0");
        }
        result = getNumA()/getNumB();
        return result;
    }
}
