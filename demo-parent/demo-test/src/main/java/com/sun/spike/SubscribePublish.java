package com.sun.spike;

import redis.clients.jedis.JedisPubSub;

/**
 * 订阅者继承发布channel
 *
 * @author sunxiang
 * @date 2021-01-22 16:11
 **/
public class SubscribePublish extends JedisPubSub {

    // 消息
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("收到消息："+message);
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
        super.onMessage(channel, message);
    }

    // 订阅
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("我订阅拉！！！");
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
        super.onSubscribe(channel, subscribedChannels);
    }

    // 取消订阅
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("我取消订阅拉！！！");
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
        super.onUnsubscribe(channel, subscribedChannels);
    }
}
