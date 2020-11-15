package com.sun.spring.annotation.clasz;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author shawn
 * @descript
 * @create 2020-11-15 9:54 下午
 */
public class SnakeFactoryBean implements FactoryBean<Snake> {

    // 获取bean对象
    @Override
    public Snake getObject() throws Exception {
        return new Snake();
    }

    // 获取bean类型
    @Override
    public Class<?> getObjectType() {
        return Snake.class;
    }

    // 是否单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
