package com.sun.proxy;

/**
 * cjlib动态代理
 * @author sunxiang
 * @date 2021-01-07 10:00
 **/
public class CjlibProxyTest {
    public static void main(String[] args) {
        TestCjlib testCjlib =new TestCjlib();
        TestService proxy = (TestService) testCjlib.getProxy(TestServiceImpl.class);
        proxy.sayTest();
    }
}
