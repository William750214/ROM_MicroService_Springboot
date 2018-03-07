package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p> Description:  HelloController </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 CSG. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@RestController
@RequestMapping("/hello1")
//@Import(DemoBean.class)
//@ImportResource(locations = {"classpath:application-bean.xml"})
public class HelloController1 {
    @Autowired
    DemoBean demoBean;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return demoBean.sayHello() + new Date();
//        return "Hello Spring Boot! " + new Date();
    }
}
