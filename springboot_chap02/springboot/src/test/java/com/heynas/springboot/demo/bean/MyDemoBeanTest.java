package com.heynas.springboot.demo.bean;

import com.heynas.springboot.demo.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p> Description:  MyDemoBeanTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class MyDemoBeanTest {

    @Autowired
    MyDemoBean myDemoBean;

    @Test
    public void sayHello() {
        System.out.println(myDemoBean.sayHello());;
    }

}
