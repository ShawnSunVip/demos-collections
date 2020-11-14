package com.sun.strategy;

/**
 * @author shawn
 * @descript
 * 收费方式策略
 * @create 2020-11-13 10:18 下午
 */
public class TollContext {
    private TollMethod tollMethod;

    public TollContext(String type) {
        switch (type){
            case "普通支付":
                tollMethod =new NormalTollMethod();
                break;
            case "八折支付":
                tollMethod =new RebateTollMethod(0.8);
                break;
            case "满300减40":
                tollMethod =new FullReductionTollMethod(300,40);
                break;
        }
    }

    public double getResult(double money){
        double toll = tollMethod.toll(money);
        return toll;
    }
}
