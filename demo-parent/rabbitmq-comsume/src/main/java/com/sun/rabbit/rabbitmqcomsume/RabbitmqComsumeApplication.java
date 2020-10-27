package com.sun.rabbit.rabbitmqcomsume;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqComsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqComsumeApplication.class, args);
    }

}
