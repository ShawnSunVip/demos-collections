package com.sun.websocket.websocketdemo.controller;

import com.sun.websocket.websocketdemo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxiang
 * @date 2020-10-20 19:51
 **/

@RestController
@RequestMapping("/test")
public class WebSocketController {

    @Autowired
    private WebSocketService webSocketService;

    @RequestMapping(value = "/saymsg", method = RequestMethod.GET)
    public String sayMsg(@RequestParam("msg") String msg){
        return webSocketService.sendMsg(msg);
    }
}
