package com.heynas.springboot.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Description:  BeanFactoryConfiguration </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Configuration
public class BeanFactoryConfiguration implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanFactoryConfiguration.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return BeanFactoryConfiguration.applicationContext.getBean(clazz);
    }
}
