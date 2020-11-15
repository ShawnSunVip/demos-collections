package com.sun.test;

import com.sun.spring.annotation.clasz.Person;
import com.sun.spring.annotation.config.MyConfig;
import com.sun.spring.annotation.config.MyConfig2;
import com.sun.spring.annotation.config.MyConfig3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class AnnocationDemo01 {

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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanNamesForAnnotation = applicationContext.getBeanDefinitionNames();
        for (String name: beanNamesForAnnotation){
            System.out.println(name);
        }
    }

    /**
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
     */
    @Test
    public void Test02(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        System.out.println("当前系统是："+applicationContext.getEnvironment().getProperty("os.name"));
        String[] beanNamesForAnnotation = applicationContext.getBeanDefinitionNames();
        for (String name: beanNamesForAnnotation){
            System.out.println(name);
        }
        System.out.println("ioc创建完成。。。");
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person1 ==person2);

        Object cat = applicationContext.getBean("cat");
        System.out.println("懒加载创建："+cat);

        Object snake = applicationContext.getBean("snakeFactoryBean");
        System.out.println("实际获取到是："+snake.getClass());

        Object snakeFactoryBean = applicationContext.getBean("&snakeFactoryBean");
        System.out.println("实际获取到是："+snakeFactoryBean.getClass());
    }

    /**
     *
     */
    @Test
    public void Test03(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig3.class);
        System.out.println("ioc创建完成。。。");

        applicationContext.close();
    }


}
