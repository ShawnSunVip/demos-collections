package com.sun.websocket.websocketdemo.websocket;

/**
 * @author sunxiang
 * @date 2020-08-05 16:33
 **/
//@Component
//@ServerEndpoint("/test/{key}/{name}")
public class WebsocketServer {


    /*@OnOpen
    public void onOpen(@PathParam("key") String key ,@PathParam("name")  String name, Session session){
        System.out.println("有新的连接："+ session);
        add(createKey(key, name), session);
        WebSocketHandler.sendMessage(session, key + name);
        System.out.println("在线人数："+count());
        sessionMap().keySet().forEach(item -> System.out.println("在线用户："+item) );
        for (Map.Entry<String, Session> item : sessionMap().entrySet()){
            System.out.println("用户: "+item.getKey());
        }
    }

    @OnMessage
    public void OnMessage(String message){
        System.out.println("消息: "+message);
    }

    @OnClose
    public void  OnClose(@PathParam("key") String key ,@PathParam("name")  String name, Session session){
        System.out.println("连接关闭: "+session);
        remove(createKey(key, name));
        System.out.println("在线人数: "+count());
        sessionMap().keySet().forEach(item ->  System.out.println("在线用户："+(item.split("@"))[1]));
        for (Map.Entry<String, Session> item : sessionMap().entrySet()){
            System.out.println("用户: "+item.getKey());
        }
    }

    @OnError
    public void OnError(Session session, Throwable throwable){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("连接异常: "+throwable);
    }*/
}
