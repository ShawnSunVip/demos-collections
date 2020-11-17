package com.sun.spring.annotation.config;

import com.sun.spring.annotation.aop.LogAspects;
import com.sun.spring.annotation.aop.MyComputer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shawn
 * @descript
 * 配置5 验证AOP 动态代理
 *  1.定义一个切面方法LogAspects
 *      通知方法
 *      1）@Before  前置通知
 *      2）@After   后置通知
 *      3）@AfterReturning   返回通知
 *      4）@AfterThrowing   异常通知
 *      5）@Around   环绕通知
 *  2.标注通知注解
 *  3.切面加注解@Aspect
 *  4.添加@EnableAspectJAutoProxy注解
 * @create 2020-11-17 9:40 下午
 */
@Configuration
@EnableAspectJAutoProxy
public class MyAopConfig {

    @Bean("computer")
    public MyComputer myComputer(){
        return new MyComputer();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
