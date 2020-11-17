package com.sun.demo.controller;

import com.sun.demo.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawn
 * @descript
 * @create 2020-11-16 10:35 下午
 */
@RestController
public class PersonController {

    @Autowired
    private PersonConfig personConfig;

    @RequestMapping("/person")
    public String showPerson(){
        return personConfig.toString();
    }
}
