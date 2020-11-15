package com.sun.spring.annotation.clasz;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author shawn
 * @descript
 * @create 2020-11-15 9:40 下午
 */
public class Monkey {

    public Monkey() {
        System.out.println("Monkey constructor ...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Monkey init ...");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Monkey destory ...");
    }
}
