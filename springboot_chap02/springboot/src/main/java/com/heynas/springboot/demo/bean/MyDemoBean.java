package com.heynas.springboot.demo.bean;

import org.heynas.springboot.DemoBean;
import org.heynas.springboot.DemoBeanProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p> Description:  MyDemoBean </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Component
public class MyDemoBean extends DemoBean {
    @Autowired
    DemoBeanProperties demoBeanProperties;

    @Override
    public String sayHello() {
        return "Hello " + demoBeanProperties.getAge() + " !";
    }
}
