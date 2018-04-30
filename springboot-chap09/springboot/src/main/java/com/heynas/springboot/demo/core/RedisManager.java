package com.heynas.springboot.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
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
public class RedisManager {
    @Autowired
    private RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public ValueOperations opsForValue() {
        return redisTemplate.opsForValue();
    }

    public HashOperations opsForHash() {
        return redisTemplate.opsForHash();
    }

    public ListOperations opsForList() {
        return redisTemplate.opsForList();
    }

    public SetOperations opsForSet() {
        return redisTemplate.opsForSet();
    }

    public ZSetOperations opsForZSet() {
        return redisTemplate.opsForZSet();
    }
}
