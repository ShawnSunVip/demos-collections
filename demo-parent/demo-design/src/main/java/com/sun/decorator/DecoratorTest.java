package com.sun.decorator;

/**
 * @author shawn
 * @descript
 * 装饰者模式
 * 实例：衣服搭配系统
 * 思路：
 * 抽象人 和 衣服2个对象
 * 衣服抽象 上衣 裤子 鞋子
 * 通过装饰模式来动态组合一个人和服饰关系
 * @create 2020-11-30 9:21 下午
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Componet person = new PersonComponet("sun");
        FineryDecorator clothes = new Clothes("皮衣");
        FineryDecorator pants = new Pants("牛仔");
        FineryDecorator shoe = new Shoe("老爹鞋");
        // 开始装饰
        clothes.setComponet(person);
        pants.setComponet(clothes);
        shoe.setComponet(pants);
        shoe.show();

    }
}
