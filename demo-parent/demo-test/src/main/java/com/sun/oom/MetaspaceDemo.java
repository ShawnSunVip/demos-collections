package com.sun.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shawn
 * @descript
 * 元空间不足：java.lang.OutOfMemoryError: Metaspace
 * jvm配置： -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * @create 2020-11-23 9:59 下午
 */
public class MetaspaceDemo {
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhance = new Enhancer();
                enhance.setSuperclass(OOMTest.class);
                enhance.setUseCache(false);
                enhance.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhance.create();
            }
        } catch (Throwable e) {
            System.out.println("异常次数i：" + i);
            e.printStackTrace();
            throw e;
        }
    }

    static class OOMTest {
    }
}
