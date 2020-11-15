package com.sun.spring.annotation.clasz;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author shawn
 * @descript
 * @create 2020-11-15 6:03 下午
 */
public class Dog implements InitializingBean, DisposableBean {
    public Dog() {
        System.out.println("Dog constructor ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog init ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Dog destroy ...");
    }
}
