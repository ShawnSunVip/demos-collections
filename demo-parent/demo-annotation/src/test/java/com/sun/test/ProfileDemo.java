package com.sun.test;

import com.sun.spring.annotation.config.MyProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:18 下午
 */
public class ProfileDemo {

    /**
     * 配置类4 @Profile
     * Profile 动态激活和切换一系列组件功能
     *  写在方法上表示只有当前环境激活才会注册这个bean
     *  写在类上表示只有当前环境激活才会注册这个配置文件
     */
    @Test
    public void Test01(){
        // 注解容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 设置激活的环境
        applicationContext.getEnvironment().setActiveProfiles("prod");
        // 注册config
        applicationContext.register(MyProfileConfig.class);
        // 刷新容器
        applicationContext.refresh();;

        System.out.println("ioc创建完成。。。");
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name: beanNamesForType){
            System.out.println(name);
        }
        applicationContext.close();
    }


}
