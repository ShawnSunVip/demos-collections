package com.sun.websocket.model;

/**
 * @author sunxiang
 * @date 2021-01-19 15:35
 **/
public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
