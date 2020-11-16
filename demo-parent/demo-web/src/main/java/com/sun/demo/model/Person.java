package com.sun.demo.model;

import com.sun.demo.factory.MyPropertySourcefactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shawn
 * @descript
 * @create 2020-11-16 10:30 下午
 */
@PropertySource(value = "classpath:/personconfig.yml",factory = MyPropertySourcefactory.class)
public class Person {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
