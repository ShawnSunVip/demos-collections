package com.sun.spike;

/**
 * 发布者测试，请启动订阅者测试SubTest
 *
 * 请在发布者控制台页面输入发送消息
 * @author sunxiang
 * @date 2021-01-22 16:21
 **/
public class PubTest {

    public static void main(String[] args) {
        Publish publish=new Publish();
        publish.run();
    }
}
