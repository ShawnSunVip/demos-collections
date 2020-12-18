package com.sun.demo.error;

/**
 * @author sunxiang
 * @date 2020-12-18 15:05
 **/
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
