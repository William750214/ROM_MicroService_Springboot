package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.config.AuthorConfigurationProperties;
import com.heynas.springboot.demo.helper.EnvironmentHelper;
import com.heynas.springboot.demo.bean.DemoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@RequestMapping("/hello")
//@Import(DemoBean.class)
//@ImportResource(locations = {"classpath:application-bean.xml"})
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DemoBean demoBean;

//    @Autowired
//    BeanFactoryConfiguration beanFactoryConfiguration;

//    @Value("${heynas.author.name}")
//    private String name;
//
//    @Value("${heynas.author.age}")
//    private Integer age;

    @Autowired
    AuthorConfigurationProperties author;

    @RequestMapping("/sayHello")
    public String sayHello() {
//        DemoBean demoBean = BeanFactoryConfiguration.getBean(DemoBean.class);
//        return demoBean.sayHello() + new Date();
//        return "Hello Spring Boot! " + new Date();
        logger.info("Info");
        logger.warn("warn");
        logger.error("error");


//        return "Name = " + author.getName() + "; Age = " + author.getAge() + "; " + new Date();
        return "Name = " + EnvironmentHelper.getProperty("heynas.author.name")
                + "; Age = " + EnvironmentHelper.getProperty("heynas.author.age") + "; "
                + "; Desc = " + EnvironmentHelper.getProperty("heynas.author.desc") + "; "
                + new Date();
//        return "Name = " + EnvironmentHelper.getProperty("heynas_name")
//                + "; Age = " + EnvironmentHelper.getProperty("heynas_age") + "; "
//                + new Date();
    }
}
