package com.sun.spike;

/**
 * 发订阅者测试，请启动发布者测试PubTest
 *
 * 可以收到发布者控制台输入的消息
 * @author sunxiang
 * @date 2021-01-22 16:18
 **/
public class SubTest {

    public static void main(String[] args) {
        Subscribe subscribe=new Subscribe();
        subscribe.run();
    }
}
