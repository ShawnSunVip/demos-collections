package com.sun.test;

import com.sun.spring.postprocessor.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class Demo01 {

    @Test
    public void Test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        String[] beanNamesForAnnotation = applicationContext.getBeanDefinitionNames();
        for (String name: beanNamesForAnnotation){
            System.out.println(name);
        }
    }
}
