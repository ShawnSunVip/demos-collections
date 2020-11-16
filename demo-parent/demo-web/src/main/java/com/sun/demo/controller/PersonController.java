package com.sun.demo.controller;

import com.sun.demo.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawn
 * @descript
 * @create 2020-11-16 10:35 下午
 */
@RestController
public class PersonController {

    @RequestMapping("/person")
    public String showPerson(){
        Person person =new Person();
        return person.toString();
    }
}
