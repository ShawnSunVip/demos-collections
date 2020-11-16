package com.sun.spring.annotation.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author shawn
 * @descript
 * 获取IOC容器
 * @create 2020-11-16 8:48 下午
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    // 获取ioc容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }


    public Object getBean(String name){
        if(applicationContext !=null){
            return applicationContext.getBean(name);
        }
        return null;
    }

    // 获取当前bean的名字
    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean的名字："+s);
    }

    // 解析 ${} #{}
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("解析数据：${os.name},#{11*12}");
        System.out.println(s);
    }
}
