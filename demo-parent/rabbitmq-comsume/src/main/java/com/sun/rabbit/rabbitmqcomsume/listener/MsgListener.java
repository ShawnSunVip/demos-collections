package com.sun.rabbit.rabbitmqcomsume.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author shawn
 * @descript
 * @create 2020-10-27 10:19 下午
 */
@Component
public class MsgListener {

    @RabbitListener(queues = "item_queue")
    public void msg(String msg){
        System.out.println("消费者消费消息了："+msg);
        //TODO 这里可以做异步的工作
    }
}
