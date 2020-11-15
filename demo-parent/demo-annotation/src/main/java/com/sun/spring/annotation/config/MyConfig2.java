package com.sun.spring.annotation.config;

import com.sun.spring.annotation.clasz.Cat;
import com.sun.spring.annotation.clasz.Dog;
import com.sun.spring.annotation.clasz.Person;
import com.sun.spring.annotation.clasz.SnakeFactoryBean;
import org.springframework.context.annotation.*;

/**
 * @author shawn
 * @descript
 * 配置类2 验证@Scope  @Lazy  @Conditional
 *  singletion  默认单实例 ioc启动时候放入容器
 *  prototype  多实例  ioc启动不会调用对象放容器，而是每次获取创建对象
 *  request 每一次HTTP请求都会产生一个新的bean
 *  session 每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效
 *  global session 全局session
 *
 *  IOC注册组件方法
 *  1。@ComponentScan包扫描或者组件注解如：@Controller等
 *  2。@Bean第三方包组件
 *  3。@Import快速给IOC导入主键
 *      1)@Import(组件名)
 *      2)ImportSelector，返回要导入类等全类名数组
 *      3)ImportBeanDefinitionRegistrar接口 手动注册到IOC
 *  4。使用FactoryBean注册
 * @create 2020-11-15 6:49 下午
 */
@Configuration
@Import({Dog.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig2 {

    @Bean("person")
    @Scope("prototype")
    public Person createPerson(){
        return new Person();
    }

    @Bean("cat")
    @Lazy
    public Cat createCat(){
        System.out.println("创建cat");
        return new Cat();
    }

    @Conditional(WindowsCondition.class)
    @Bean("zhangsan")
    public Person createPerson1(){
        System.out.println("我在windows下创建bean");
        return new Person();
    }

    @Conditional(MacCondition.class)
    @Bean("lisi")
    public Person createPerson2(){
        System.out.println("我在mac下创建bean");
        return new Person();
    }

    @Bean
    public SnakeFactoryBean snakeFactoryBean(){
        return new SnakeFactoryBean();
    }

}
