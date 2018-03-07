package org.heynas.springboot;

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

public class DemoBean {
    public String name;
    public Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String sayHello() {
        return "Hello " + this.getName() + " !";
    }
}
