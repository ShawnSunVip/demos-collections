package com.sun.demo.config;

import com.sun.demo.factory.MyPropertySourcefactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author shawn
 * @descript
 * @create 2020-11-16 10:41 下午
 */
@Component
@PropertySource(value = "classpath:/personconfig.yml",factory = MyPropertySourcefactory.class)
public class PersonConfig {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
