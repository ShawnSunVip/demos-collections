package com.sun.decorator;

/**
 * @author shawn
 * @descript
 * 装饰类 鞋
 * @create 2020-11-30 9:46 下午
 */
public class Shoe extends FineryDecorator{
    private String name;

    public Shoe(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
        super.show();
    }
}
