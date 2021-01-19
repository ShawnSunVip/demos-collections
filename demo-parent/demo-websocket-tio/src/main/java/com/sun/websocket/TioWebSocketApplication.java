package com.sun.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tio.websocket.starter.EnableTioWebSocketServer;

/**
 * @author sunxiang
 * @date 2021-01-19 15:22
 **/

@SpringBootApplication
@EnableTioWebSocketServer
public class TioWebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(TioWebSocketApplication.class,args);
    }
}
