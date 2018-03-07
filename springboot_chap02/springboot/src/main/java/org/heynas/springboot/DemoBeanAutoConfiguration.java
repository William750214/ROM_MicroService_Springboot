package org.heynas.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Description:  DemoBeanAutoConfiguration </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Configuration
@EnableConfigurationProperties(DemoBeanProperties.class)
public class DemoBeanAutoConfiguration {
    @Autowired
    DemoBeanProperties demoBeanProperties;

    @Bean
    @ConditionalOnMissingBean(DemoBean.class)
    public DemoBean demoBean() {
        DemoBean demoBean = new DemoBean();
        demoBean.setName(demoBeanProperties.getName());
        return demoBean;
    }
}
