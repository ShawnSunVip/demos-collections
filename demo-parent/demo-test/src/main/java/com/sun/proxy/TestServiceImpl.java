package com.sun.proxy;

/**
 * @author sunxiang
 * @date 2021-01-07 9:47
 **/
public class TestServiceImpl implements TestService{
    @Override
    public void sayTest() {
        System.out.println("init");
    }
}
