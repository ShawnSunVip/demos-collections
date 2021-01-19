package com.sun.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cjlib代理类
 * @author sunxiang
 * @date 2021-01-07 10:01
 **/
public class TestCjlib implements MethodInterceptor {

    private Enhancer enhancer =new Enhancer();

    public Object getProxy(Class clasz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clasz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cjlib start...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cjlib end...");
        return result;
    }
}
