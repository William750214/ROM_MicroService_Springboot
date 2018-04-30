package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.core.RedisManager;
import com.heynas.springboot.demo.domain.Student;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
@Api(tags = "Hello Controller说明")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RedisManager redisManager;

    @RequestMapping(value = "/sayHello", method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    public String sayHello(HttpServletRequest request) {
//        redisManager.getRedisTemplate().setEnableTransactionSupport(true);

//        redisManager.opsForValue().set("key01","Hello Redis!");

//        new HashMap().get("abc").toString();

//        return "Hello Spring Boot!" + new Date();

        return request.getSession().getId();
    }

    @RequestMapping(value = "/sayHelloStudent", method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    @ApiOperation(value = "Say Hello Student", notes = "Say Hello Student说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name01", required = true, paramType = "query"),
            @ApiImplicitParam(name = "age", value = "age01", required = true, paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Student sayHelloStudent(String name, Integer age) {

        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        return student;
    }
}
