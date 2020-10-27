package com.sun.rabbit.rabbitmqcomsume.client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author shawn
 * @descript
 * @create 2020-10-27 10:41 下午
 */
public class MQTTCallBack implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("进入connectionLost方法，可以在此重新连接");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("进入messageArrived方法---->：" + "\n主题：" + topic + "\n服务保障：" + message.getQos() +
                "\n消息id：" + message.getId() + "\n消息体：" + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
            System.out.println("进入deliveryComplete方法，消息发送是否完成：" + token.isComplete() + "/n消息id：" + token.getMessageId() +
                    "/n消息服务：" + token.getMessage().getQos() + "\n消息内容：" + new String(token.getMessage().getPayload()));
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
