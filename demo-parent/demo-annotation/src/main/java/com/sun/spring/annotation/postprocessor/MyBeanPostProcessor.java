package com.sun.spring.annotation.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shawn
 * @descript
 * Bean的后置处理器
 * @create 2020-11-12 10:29 下午
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化之前工作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor==="+"before==="+beanName+"=>"+bean);
        return bean;
    }

    /**
     * 在初始化之后工作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor==="+"after==="+beanName+"=>"+bean);
        return bean;
    }
}
