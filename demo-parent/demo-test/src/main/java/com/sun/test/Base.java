package com.sun.test;

import org.springframework.context.annotation.Scope;

/**
 * @author shawn
 * @descript
 * @create 2020-12-02 10:30 下午
 */
@Scope("prototype")
public class Base {
    private String base;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Base{" +
                "base='" + base + '\'' +
                '}';
    }
}
