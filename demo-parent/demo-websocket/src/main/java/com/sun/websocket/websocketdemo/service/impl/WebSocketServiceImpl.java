package com.sun.websocket.websocketdemo.service.impl;

import com.sun.websocket.websocketdemo.handler.WebSocketHandler;
import com.sun.websocket.websocketdemo.service.WebSocketService;
import com.sun.websocket.websocketdemo.websocket.WebsocketPool;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.websocket.Session;
import java.util.Map;

/**
 * @author shawn
 * @descript
 * @create 2020-10-20 11:02 下午
 */
@Service
public class WebSocketServiceImpl  implements WebSocketService {

    private WebsocketPool websocketPool;
    private WebSocketHandler webSocketHandler;

    @Override
    public String sendMsg(String msg) {
        Map<String, Session> sessions = websocketPool.sessionMap();
        if (!CollectionUtils.isEmpty(sessions)){
            Session session =sessions.get("kis@sun");
            if(session !=null){
                webSocketHandler.sendMessage(session,msg);
                return "服务器下发指令："+msg;
            }

        }
        return "";
    }
}
