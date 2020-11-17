package com.sun.test;

import com.sun.spring.annotation.config.MyScanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class ScanDemo {

    /**
     * 配置类1 验证@ComponentScan功能
     *
     * @ComponentScan value定义扫描的包
     *  excludeFilters 指定扫描时候排除什么
     *      例：excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})}
     *  includeFilters 指定扫描时候包括什么 这时候需要定义useDefaultFilters = false 关闭默认扫描配置
     *      例：includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Cat.class})},useDefaultFilters = false
     *  FilterType.ANNOTATION 按照注解
     *  FilterType.ASPECTJ  按照ASPECTJ表达式
     *  FilterType.ASSIGNABLE_TYPE 按照给定类型
     *  FilterType.REGEX    按照正则
     *  FilterType.CUSTOM 自定义规则
     *      例：excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})}
     */
    @Test
    public void Test01(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyScanConfig.class);
        String[] beanNamesForAnnotation = applicationContext.getBeanDefinitionNames();
        for (String name: beanNamesForAnnotation){
            System.out.println(name);
        }
    }

}
