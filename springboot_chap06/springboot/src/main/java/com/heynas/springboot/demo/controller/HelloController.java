package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.core.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
    private RedisManager redisManager;

    @RequestMapping("/sayHello")
    @Transactional
    public String sayHello(HttpServletRequest request) {
//        redisManager.getRedisTemplate().setEnableTransactionSupport(true);

//        redisManager.opsForValue().set("key01","Hello Redis!");

//        new HashMap().get("abc").toString();

//        return "Hello Spring Boot!" + new Date();

        return request.getSession().getId();
    }
}
