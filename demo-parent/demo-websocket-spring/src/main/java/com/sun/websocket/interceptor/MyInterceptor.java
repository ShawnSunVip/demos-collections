package com.sun.websocket.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * websocket拦截器
 * @author sunxiang
 * @date 2021-01-19 14:59
 **/
public class MyInterceptor implements HandshakeInterceptor {

    private final static String USERID="user_id";
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("握手开始");
        // 获得请求参数
        HashMap<String, String> paramMap = (HashMap<String, String>) HttpUtil.decodeParamMap(request.getURI().getQuery(), "utf-8");
        String userId = paramMap.get(USERID);
        if (StrUtil.isNotBlank(userId)) {
            // 放入属性域
            map.put("token", userId);
            System.out.println("用户 " + userId + " 握手成功！");
            return true;
        }
        System.out.println("用户登录已失效");
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("握手完成");
    }
}
