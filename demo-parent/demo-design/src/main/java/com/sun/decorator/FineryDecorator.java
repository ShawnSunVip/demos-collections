package com.sun.decorator;

/**
 * @author shawn
 * @descript
 *
 * 装饰抽象类  服饰
 * @create 2020-11-30 9:30 下午
 */
public class FineryDecorator extends Componet{

    private Componet componet;

    public void setComponet(Componet componet) {
        this.componet = componet;
    }

    @Override
    public void show() {
        componet.show();
    }
}
