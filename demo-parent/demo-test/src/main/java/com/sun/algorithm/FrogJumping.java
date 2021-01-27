package com.sun.algorithm;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author sunxiang
 * @date 2021-01-27 16:21
 **/
public class FrogJumping {
    public static void main(String[] args) {
        System.out.println(jumpFloor(10));
    }

    static int jumpFloor(int number) {
        if(number<=0){
            return 0;
        }
        if(number==1){
            return 1;
        }
        if(number==2){
            return 2;
        }
        int first =1,second=2,three=0;
        for (int i = 3; i <= number; i++) {
            three =first+second;
            first=second;
            second=three;
        }
        return three;
    }
}
