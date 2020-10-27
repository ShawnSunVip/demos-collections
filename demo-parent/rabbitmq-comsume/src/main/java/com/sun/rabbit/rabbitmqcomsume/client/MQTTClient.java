package com.sun.rabbit.rabbitmqcomsume.client;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author shawn
 * @descript
 * @create 2020-10-27 10:43 下午
 */
public class MQTTClient {
    private String host ="tcp://47.103.96.71:5672";
    private String clientId ="client";
    private String userName="guest";
    private String password="guest";
    private MqttClient mqttClient;
    private MqttTopic topic;

    public MQTTClient() throws MqttException {
        mqttClient = new MqttClient(host, clientId, new MemoryPersistence());
        connect();
    }

    public void connect() throws MqttSecurityException, MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setCleanSession(true);
        options.setConnectionTimeout(30);
        options.setKeepAliveInterval(60);
        mqttClient.setCallback(new MQTTCallBack());
        topic = mqttClient.getTopic("topic_001");
        mqttClient.connect(options);
    }

    public void subscribe(String[] topic, int[] qos) throws MqttException {
        mqttClient.subscribe(topic, qos);
    }

    public static void main(String[] args) throws MqttException {
        MQTTClient mqClient = new MQTTClient();
        String[] topic = {"topic_001"};
        int[] qos = {2};
        mqClient.subscribe(topic, qos);
    }

}
