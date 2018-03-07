package org.heynas.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> Description:  DemoBeanProperties </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@ConfigurationProperties(prefix = "heynas.author")
public class DemoBeanProperties {
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
}
