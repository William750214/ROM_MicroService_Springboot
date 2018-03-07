package com.heynas.springboot.demo.helper;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * <p> Description:  EnvironmentHelper </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Configuration
public class EnvironmentHelper implements EnvironmentAware {
    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        EnvironmentHelper.environment = environment;
    }

    public static String getProperty(String key) {
        return EnvironmentHelper.environment.getProperty(key);
    }
}
