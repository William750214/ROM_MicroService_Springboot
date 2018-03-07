package com.heynas.springboot.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * <p> Description:  RedisManager </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Component
public class MongoManager {
    @Autowired
    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void add(Object obj) {
        mongoTemplate.save(obj);
    }

    public <T> T findByPk(String strPk, Class<T> clazz) {
        return mongoTemplate.findById(strPk, clazz);
    }

}
