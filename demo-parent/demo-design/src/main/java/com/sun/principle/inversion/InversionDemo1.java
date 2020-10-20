package com.sun.principle.inversion;

/**
 * @author shawn
 * @descript 依赖倒置原则
 * @create 2020-10-12 8:55 下午
 */
public class InversionDemo1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getMessage(){
        return "获得邮件";
    }
}

class Person {
    public void receive(Email e){
        System.out.println(e.getMessage());
    }
}
