package com.sun.test;

/**
 * @author shawn
 * @descript
 * @create 2020-10-25 10:24 上午
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("6 ^ 1="+(109799392 & 16));
        int in = highestOneBit(8);
        System.out.println(in);

    }
    public static int highestOneBit(int num){
        return num>16?16:(num > 1)?Integer.highestOneBit((num)<<1):1;
    }
}

