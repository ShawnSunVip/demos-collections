package com.sun.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shawn
 * @descript
 * @create 2020-12-02 10:31 下午
 */
public class PersonTest {
    public static void main(String[] args) {
        Person x =null;
        x.setName("xxx");

        Person p = new Person();
        p.setBase("base1");
        p.setAge(1);
        p.setName("hah");
        ConcurrentHashMap<String ,Person> map = new ConcurrentHashMap<>(0);

        map.put("hah",p);
        for(Map.Entry<String,Person> entry : map.entrySet() ){
            if(entry.getValue() == p){
                System.out.println(entry.getKey());
            }
        }
        p.setBase("base2");
        for(Map.Entry<String,Person> entry : map.entrySet() ){
            if(entry.getValue() == p){
                System.out.println(entry.getKey());
            }
        }


    }
}
