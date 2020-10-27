package com.sun.rabbit.rabbitmqproduce;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProduceApplication.class, args);
    }

}
