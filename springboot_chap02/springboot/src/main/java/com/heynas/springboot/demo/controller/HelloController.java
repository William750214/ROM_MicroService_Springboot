package com.heynas.springboot.demo.controller;

import org.heynas.springboot.DemoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

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
@RequestMapping("/hello")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DemoBean demoBean;

    @RequestMapping("/sayHello")
    public String sayHello() {

        new HashMap().get("abc").toString();

        return demoBean.sayHello() + new Date();
    }
}
