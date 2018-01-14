package com.ronglexie.ronglexiegirl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ronglexie
 * @version 2018-1-14
 */

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot!";
    }

    @GetMapping("sayHello")
    public String sayHelloToHtml(){
        return "index";
    }
}
