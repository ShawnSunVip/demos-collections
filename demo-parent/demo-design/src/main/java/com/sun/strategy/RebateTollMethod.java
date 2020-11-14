package com.sun.strategy;

/**
 * @author shawn
 * @descript
 * 打折方式
 * @create 2020-11-13 10:24 下午
 */
public class RebateTollMethod extends TollMethod{

    // 折扣
    private double rebate=1d;

    public RebateTollMethod(double rebate) {
        this.rebate = rebate;
    }

    @Override
    public double toll(double money) {
        return money*rebate;
    }
}
