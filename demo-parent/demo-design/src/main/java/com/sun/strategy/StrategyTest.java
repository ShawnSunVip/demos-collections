package com.sun.strategy;

/**
 * @author shawn
 * @descript
 * 策略模式
 * 实例：商场收银
 * 思路：
 * 根据不同的活动方式计算收款金额
 * 不同活动方式的算法剥离可扩展
 * 实现：
 * @create 2020-11-13 7:42 下午
 */
public class StrategyTest {
    public static void main(String[] args) {
        double price=120;
        double num=4;
        double total=price * num;
        TollContext toll = new TollContext("普通支付");
        double result = toll.getResult(total);
        System.out.println("单价："+price+"\t数量："+num+"\t应支付："+total+"\t实际支付："+result);

        TollContext toll1 = new TollContext("八折支付");
        double result1 = toll1.getResult(total);
        System.out.println("单价："+price+"\t数量："+num+"\t应支付："+total+"\t实际支付："+result1);

        TollContext toll2 = new TollContext("满300减40");
        double result2 = toll2.getResult(total);
        System.out.println("单价："+price+"\t数量："+num+"\t应支付："+total+"\t实际支付："+result2);
    }
}
