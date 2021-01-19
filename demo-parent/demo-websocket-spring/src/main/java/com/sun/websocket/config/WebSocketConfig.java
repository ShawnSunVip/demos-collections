package com.sun.websocket.config;

import com.sun.websocket.handle.MyWebSocketHandle;
import com.sun.websocket.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * websocket配置
 * @author sunxiang
 * @date 2021-01-19 14:57
 **/

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandle(),"mysocket").
                addInterceptors(myInterceptor()).
                setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler myHandle(){
        return new MyWebSocketHandle();
    }

    @Bean
    public HandshakeInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
