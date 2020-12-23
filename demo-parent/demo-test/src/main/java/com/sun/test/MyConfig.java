package com.sun.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shawn
 * @descript
 * @create 2020-12-02 10:38 下午
 */
@Configuration
@ComponentScan("com.sun.test")
public class MyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
