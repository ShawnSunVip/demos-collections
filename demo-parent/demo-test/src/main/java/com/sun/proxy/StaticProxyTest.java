package com.sun.proxy;

/**
 * 静态代理测试
 * @author sunxiang
 * @date 2021-01-07 9:47
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        TestService testService =new TestServiceImpl();
        TestServiceProxy target = new TestServiceProxy(testService);
        target.sayTest();
    }
}
