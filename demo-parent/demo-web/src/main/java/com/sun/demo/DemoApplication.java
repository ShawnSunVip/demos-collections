package com.sun.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author sunxiang
 * @date 2020-10-20 19:50
 **/

@SpringBootApplication
public class DemoApplication  {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
