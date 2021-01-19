package com.sun.proxy;

/**
 * 静态代理
 * @author sunxiang
 * @date 2021-01-07 9:49
 **/
public class TestServiceProxy implements TestService{

    private TestService testService;

    public TestServiceProxy(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void sayTest() {
        System.out.println("proxy start...");
        testService.sayTest();
        System.out.println("proxy end...");
    }
}
