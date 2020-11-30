package com.sun.decorator;

/**
 * @author shawn
 * @descript
 * 装饰类-裤子
 * @create 2020-11-30 9:37 下午
 */
public class Pants extends FineryDecorator{
    private String name;

    public Pants(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
        super.show();
    }
}
