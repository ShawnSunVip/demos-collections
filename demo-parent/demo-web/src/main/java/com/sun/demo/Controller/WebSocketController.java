package com.sun.demo.Controller;

import com.sun.websocket.websocketdemo.handler.WebSocketHandler;
import com.sun.websocket.websocketdemo.websocket.WebsocketPool;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.util.Map;

/**
 * @author sunxiang
 * @date 2020-10-20 19:51
 **/

@RestController
@RequestMapping("/test")
public class WebSocketController {

    @Resource
    private WebSocketHandler webSocketHandler;

    @Resource
    private WebsocketPool websocketPool;

    @RequestMapping(value = "/saymsg", method = RequestMethod.GET)
    public String sayMsg(@RequestParam("msg") String msg){
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
