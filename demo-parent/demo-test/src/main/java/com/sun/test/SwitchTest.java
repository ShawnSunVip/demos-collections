package com.sun.test;

/**
 * @author shawn
 * @descript
 * @create 2020-10-25 10:24 上午
 */
public class SwitchTest {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }

    }
}

