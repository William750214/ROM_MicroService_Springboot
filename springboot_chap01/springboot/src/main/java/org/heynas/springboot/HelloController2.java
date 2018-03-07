package org.heynas.springboot;

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
@RequestMapping("/hello2")
public class HelloController2 {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello Spring Boot! " + new Date();
    }
}
