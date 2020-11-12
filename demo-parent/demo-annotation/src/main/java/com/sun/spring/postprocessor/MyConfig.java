package com.sun.spring.postprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shawn
 * @descript
 * @create 2020-11-12 10:38 下午
 */
@Configuration
@ComponentScan("com.sun.spring.postprocessor")
public class MyConfig {

    @Bean
    public People people(){
        return new People();
    }
}
