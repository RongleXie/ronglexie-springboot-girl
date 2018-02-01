package com.ronglexie.ronglexiegirl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ronglexie
 * @version 2018-1-14
 */

@Controller
public class HelloController {

    @GetMapping("hello")
    public String sayHello(){
        return "index";
    }

}
