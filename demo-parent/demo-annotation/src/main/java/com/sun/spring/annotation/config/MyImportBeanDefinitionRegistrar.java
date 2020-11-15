package com.sun.spring.annotation.config;

import com.sun.spring.annotation.clasz.Panda;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shawn
 * @descript
 * 基于@Import 自定义选择器
 * @create 2020-11-15 9:43 下午
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类注解信息
     * @param registry 注册类，把需要注册到IOC中组件注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean panda = registry.containsBeanDefinition("panda");
        if(!panda){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Panda.class);
            registry.registerBeanDefinition("panda", rootBeanDefinition);
        }
    }
}
