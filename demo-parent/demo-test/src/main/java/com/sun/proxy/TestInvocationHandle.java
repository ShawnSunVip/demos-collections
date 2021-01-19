package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author sunxiang
 * @date 2021-01-07 9:53
 **/
public class TestInvocationHandle implements InvocationHandler {

    private Object object;

    public TestInvocationHandle(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocationHandle start...");
        Object result = method.invoke(object, args);
        System.out.println("invocationHandle end...");
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),object.getClass().getInterfaces(),this);
    }
}
