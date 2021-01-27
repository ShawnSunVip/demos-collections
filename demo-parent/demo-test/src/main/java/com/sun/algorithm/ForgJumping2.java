package com.sun.algorithm;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author sunxiang
 * @date 2021-01-27 16:25
 **/
public class ForgJumping2 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(10));
    }
    static  int JumpFloorII(int number){
        return 1 << --number;
    }
}
