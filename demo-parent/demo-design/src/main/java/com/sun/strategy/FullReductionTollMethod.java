package com.sun.strategy;

/**
 * @author shawn
 * @descript
 * 满减方式
 * @create 2020-11-13 10:46 下午
 */
public class FullReductionTollMethod extends TollMethod {
    // 满减金额
    private double targetCash;
    // 返现金额
    private double reductionCash;

    public FullReductionTollMethod(double targetCash, double reductionCash) {
        this.targetCash = targetCash;
        this.reductionCash = reductionCash;
    }

    @Override
    public double toll(double money) {
        // 商品金额大于满减金额
        if(money >= targetCash){
            return money - Math.floor(money/targetCash)*reductionCash;
        }
        return money;
    }
}
