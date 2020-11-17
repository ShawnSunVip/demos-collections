package com.sun.test;

import com.sun.spring.annotation.aop.MyComputer;
import com.sun.spring.annotation.config.MyAopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class AopDemo {

    /**
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
     */
    @Test
    public void Test01(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAopConfig.class);
        System.out.println("ioc创建完成。。。");
        MyComputer computer =(MyComputer)applicationContext.getBean("computer");
        computer.test(1,0);
        applicationContext.close();
    }

}
