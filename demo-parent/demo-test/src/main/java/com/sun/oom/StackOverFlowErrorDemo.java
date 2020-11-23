package com.sun.oom;

/**
 * @author shawn
 * @descript
 * 栈溢出错误 java.lang.StackOverflowError
 *  递归方法太多导致栈爆了
 * @create 2020-11-23 8:58 下午
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
