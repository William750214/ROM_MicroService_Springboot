package com.heynas.springboot.demo.core;

import com.heynas.springboot.demo.SpringbootApplication;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p> Description:  RedisManagerTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class RedisManagerTest {
    @Autowired
    private RedisManager redisManager;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private static String str = "abc";
    private static int int01 = 123;
    private static long long01 = 123l;
    private static Date date = new Date(1504534829398l);
    private static Map map01 = new HashMap();
    private static List lst01 = new ArrayList();


    @BeforeClass
    public static void setUp() {
        map01.put("strField", "a");
        map01.put("intField", 1);
        map01.put("longField", 1l);
        map01.put("decimalField", new BigDecimal("123.456"));
        map01.put("dateField", date);
        lst01.add("a");
        lst01.add(1);
        lst01.add(1l);
        lst01.add(new BigDecimal("123.456"));
        lst01.add(date);
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void opsForValue() {
        ValueOperations valueOperations = redisManager.opsForValue();
        valueOperations.set("str", str);
        valueOperations.set("int01", int01);
        valueOperations.set("long01", long01);
        valueOperations.set("date", date);
        valueOperations.set("map01", map01);
        valueOperations.set("lst01", lst01);

        Assert.assertEquals(valueOperations.get("str"), str);
        Assert.assertEquals((int) valueOperations.get("int01"), int01);
        Assert.assertEquals((long) valueOperations.get("long01"), long01);
        Assert.assertEquals(valueOperations.get("date"), date);
        Assert.assertEquals(valueOperations.get("map01"), map01);
        Assert.assertEquals(valueOperations.get("lst01"), lst01);
    }

    @Test
    public void opsForHash() {
        HashOperations hashOperations = redisManager.opsForHash();

        hashOperations.put("hash","str", str);
        hashOperations.put("hash","int01", int01);
        hashOperations.put("hash","long01", long01);
        hashOperations.put("hash","date", date);
        hashOperations.put("hash","map01", map01);
        hashOperations.put("hash","lst01", lst01);

        Assert.assertEquals(hashOperations.get("hash","str"), str);
    }
}
