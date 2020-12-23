package com.sun.test;

import org.springframework.context.annotation.Scope;

/**
 * @author shawn
 * @descript
 * @create 2020-12-02 10:27 下午
 */
@Scope("prototype")
public class Person extends Base {
    private String name;
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
