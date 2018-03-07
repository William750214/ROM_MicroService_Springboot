package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.core.MongoManager;
import com.heynas.springboot.demo.domain.MongoStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p> Description:  StudentController </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@RestController
@RequestMapping("/mongostudent")
public class MongoStudentController {
    @Autowired
    MongoManager manager;

    @RequestMapping("/add")
    public String add(Object requestBody) {
        String strPk = UUID.randomUUID().toString();

        MongoStudent student = new MongoStudent();
        student.setUuid(strPk);
        student.setName("zhangsan");
        student.setAge(18);

        manager.add(student);

        return strPk;
    }

    @RequestMapping("/findByPk/{uuid}")
    public MongoStudent findByPk(@PathVariable String uuid) {
//        return studentService.findByPk(uuid);
        return manager.findByPk(uuid, MongoStudent.class);
    }
//
//    @RequestMapping("/deleteAll")
//    public void deleteAll() {
////        studentService.deleteAll();
//        studentService1.deleteAll();
//    }
//
//    @RequestMapping("/find/{name}")
//    public List<Student> find(@PathVariable String name) {
//        return studentService1.find(name);
//    }
}
