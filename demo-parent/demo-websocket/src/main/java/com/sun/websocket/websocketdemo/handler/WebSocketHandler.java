package com.sun.websocket.websocketdemo.handler;

import org.springframework.stereotype.Component;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import static com.sun.websocket.websocketdemo.websocket.WebsocketPool.sessionMap;
/**
 * @author sunxiang
 * @date 2020-08-05 16:44
 **/
@Component
public class WebSocketHandler {

    public static String createKey(String key,String name){
        return key+"@"+name;
    }

    public static void sendMessage(Session session,String msg){
        if(session ==null){
            return;
        }
        final RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
        if(basicRemote ==null){
            return;
        }
        try {
            basicRemote.sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageAll(String message){
        sessionMap().forEach((key, session) -> sendMessage(session, message));
    }
}
