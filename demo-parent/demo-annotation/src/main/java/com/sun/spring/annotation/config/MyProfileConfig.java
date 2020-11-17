package com.sun.spring.annotation.config;

import com.sun.spring.annotation.clasz.DataSourceDev;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author shawn
 * @descript
 * 配置类4 @Profile
 * Profile 动态激活和切换一系列组件功能
 *  写在方法上表示只有当前环境激活才会注册这个bean
 *  写在类上表示只有当前环境激活才会注册这个配置文件
 * @PropertySource默认只支持properties文件
 * 怎么使其支持yml文件
 * 通过继承DefaultPropertySourceFactory
 * 重写createPropertySource
 * 来实现@PropertySource注解支持yml文件
 * @create 2020-11-16 9:01 下午
 */
@Configuration
@PropertySource("classpath:/dbconfig.properties")
public class MyProfileConfig implements EmbeddedValueResolverAware {

    @Value("${mydb.user}")
    private String user;

    private StringValueResolver resolver;

    private String driveClass;

    @Profile("dev")
    @Bean("dataSourcesDev")
    public DataSource dataSourcesDev() {
        System.out.println("这是开发环境:user:"+user+",driveClass:"+driveClass);
        return new DataSourceDev();
    }

    @Profile("prod")
    @Bean("dataSourcesProd")
    public DataSource dataSourcesProd() {
        System.out.println("这是生产环境:user:"+user+",driveClass:"+driveClass);
        return new DataSourceDev();
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.resolver=stringValueResolver;
        driveClass=resolver.resolveStringValue("${mydb.driverClass}");
    }
}
