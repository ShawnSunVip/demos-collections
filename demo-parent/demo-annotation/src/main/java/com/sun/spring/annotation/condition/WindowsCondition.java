package com.sun.spring.annotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shawn
 * @descript
 * 基于@Condition 自定义条件bean容器——windows
 * @create 2020-11-15 7:09 下午
 */
public class WindowsCondition implements Condition {

    /**
     *
     * @param conditionContext 使用条件的上下文
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取ioc的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 获取类的加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 获取环境信息
        Environment environment = conditionContext.getEnvironment();
        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")){
            return true;
        }
        return false;
    }
}
