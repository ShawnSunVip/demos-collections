package com.sun.websocket.websocketdemo.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket连接池
 * @author sunxiang
 * @date 2020-08-05 17:24
 **/
@Component
public class WebsocketPool {
    //在线用户websocket连接池
    private static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();

    /**
     * 新增一则连接
     * @param key
     * @param session
     */
    public static void add(String key, Session session){
        if (!key.isEmpty() && session != null){
            ONLINE_USER_SESSIONS.put(key, session);
        }
    }

    /**
     * 根据Key删除连接
     * @param key
     */
    public static void remove(String key){
        if (!key.isEmpty()){
            ONLINE_USER_SESSIONS.remove(key);
        }
    }

    /**
     * 获取在线人数
     * @return
     */
    public static int count(){
        return ONLINE_USER_SESSIONS.size();
    }

    /**
     * 获取在线session池
     * @return
     */
    public static Map<String, Session> sessionMap(){
        return ONLINE_USER_SESSIONS;
    }
}
