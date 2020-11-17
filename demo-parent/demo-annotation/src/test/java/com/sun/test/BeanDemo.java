package com.sun.test;

import com.sun.spring.annotation.config.MyBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class BeanDemo {

    /**
     * 配置类3 验证Bean的生命周期
     * Bean的生命周期
     *     创建-》初始化-》销毁
     * 三种方式
     *  1）指定初始化方法 init 和 destory
     *  2）InitializingBean和DisposableBean接口实现
     *  3）@PostConstruct 和@PreDestory注解
     *  4）BeanPostProceor后置处理器
     */
    @Test
    public void Test01(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("ioc创建完成。。。");

        applicationContext.close();
    }

}
