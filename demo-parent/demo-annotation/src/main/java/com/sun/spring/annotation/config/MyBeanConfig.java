package com.sun.spring.annotation.config;

import com.sun.spring.annotation.clasz.Cat;
import com.sun.spring.annotation.clasz.Dog;
import com.sun.spring.annotation.clasz.Monkey;
import com.sun.spring.annotation.postprocessor.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shawn
 * @descript
 * 配置类3 验证Bean的生命周期
 * Bean的生命周期
 *     创建-》初始化-》销毁
 * 三种方式
 *  1）指定初始化方法 init 和 destory
 *  2）InitializingBean和DisposableBean接口实现
 *  3）@PostConstruct 和@PreDestory注解
 *  4）BeanPostProceor后置处理器
 * @create 2020-11-15 10:03 下午
 */
@Configuration
@Import(MyBeanPostProcessor.class)
public class MyBeanConfig {

    @Bean(initMethod = "init", destroyMethod = "detory")
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public Monkey monkey(){
        return new Monkey();
    }

}
