package com.sun.principle.inversion;

/**
 * @author shawn
 * @descript 依赖倒置原则
 * @create 2020-10-12 9:10 下午
 */
public class InversionDemo2 {
    public static void main(String[] args) {
        NewPerson person = new NewPerson();
        person.receive(new Email2());
        person.receive(new Weixin());
    }
}

interface IReceiver {
    String getMessage();
}

class Email2 implements IReceiver {
    public String getMessage() {
        return "获得邮件消息";
    }
}

class Weixin implements IReceiver {
    public String getMessage() {
        return "获得微信消息";
    }
}

class NewPerson {
    public void receive(IReceiver e){
        System.out.println(e.getMessage());
    }
}
