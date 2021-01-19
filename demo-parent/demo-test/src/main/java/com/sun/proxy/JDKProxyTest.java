package com.sun.proxy;

/**
 * jdk代码测试
 * @author sunxiang
 * @date 2021-01-07 9:52
 **/
public class JDKProxyTest {
    public static void main(String[] args) {
        TestService testService=new TestServiceImpl();
        TestInvocationHandle handle =new TestInvocationHandle(testService);
        TestService proxy = (TestService)handle.getProxy();
        proxy.sayTest();

    }
}
