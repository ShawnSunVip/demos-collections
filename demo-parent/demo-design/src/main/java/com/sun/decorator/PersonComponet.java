package com.sun.decorator;

/**
 * @author shawn
 * @descript
 * 抽象的对象人
 * @create 2020-11-30 9:28 下午
 */
public class PersonComponet extends Componet {

    private String name;

    public PersonComponet(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}
