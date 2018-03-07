package com.heynas.springboot.demo.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p> Description:  DemoBean </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Component
//    @Service
public class DemoBean {
    public String sayHello() {
        return "Hello Bean!";
    }
}
