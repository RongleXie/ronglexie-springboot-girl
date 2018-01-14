package com.ronglexie.ronglexiegirl.web;

import com.ronglexie.ronglexiegirl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ronglexie
 * @version 2018-1-14
 */
@RestController
public class GirlController {

    @Autowired
    GirlProperties girlProperties;

    @GetMapping("girl")
    public String girl(){
        return "Age:"+girlProperties.getAge()+"  CupSize:"+girlProperties.getCupSize();
    }
}
