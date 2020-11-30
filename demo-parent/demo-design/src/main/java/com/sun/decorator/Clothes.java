package com.sun.decorator;

/**
 * @author shawn
 * @descript
 * 装饰类 衣服
 * @create 2020-11-30 9:35 下午
 */
public class Clothes extends FineryDecorator{

    private String name;

    public Clothes(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
        super.show();
    }
}
