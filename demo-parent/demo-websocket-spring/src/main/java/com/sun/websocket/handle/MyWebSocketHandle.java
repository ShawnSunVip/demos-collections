package com.sun.websocket.handle;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;

/**
 * websocket处理器
 * @author sunxiang
 * @date 2021-01-19 14:58
 **/
public class MyWebSocketHandle extends TextWebSocketHandler {

    private final static String USERID="user_id";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = (String)session.getAttributes().get(USERID);
        WsSessionManager.add(userId,session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        String userId = (String)session.getAttributes().get(USERID);
        session.sendMessage(new TextMessage("server 发送给 " + userId + " 消息 " + payload + " " + LocalDateTime.now().toString()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String userId = (String)session.getAttributes().get(USERID);
        WsSessionManager.remove(userId);
    }
}
