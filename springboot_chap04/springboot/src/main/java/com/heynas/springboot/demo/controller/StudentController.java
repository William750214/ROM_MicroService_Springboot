package com.heynas.springboot.demo.controller;

import com.heynas.springboot.demo.domain.Student;
import com.heynas.springboot.demo.service.StudentService;
import com.heynas.springboot.demo.service.StudentService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentService1 studentService1;

    @RequestMapping("/add")
    @CachePut(value = "student", key = "#student.uuid")
    public Student add(Student student) {
        student.setName("zhangsan");
        student.setAge(18);

        studentService.add(student);

        return student;
    }

    @RequestMapping("/findByPk/{uuid}")
    @Cacheable(value = "student", key = "#uuid")
    public Student findByPk(@PathVariable String uuid) {
//        return studentService.findByPk(uuid);
        return studentService1.findByPk(uuid);
    }

    @RequestMapping("/delete/{uuid}")
    @CacheEvict(value = "student", key = "#uuid")
    public void delete(@PathVariable String uuid) {
//        return studentService.findByPk(uuid);
        studentService1.delete(uuid);
    }

    @RequestMapping("/deleteAll")
    @CacheEvict(value = "student", allEntries = true)
    public void deleteAll() {
//        studentService.deleteAll();
        studentService1.deleteAll();
    }

    @RequestMapping("/find/{name}")
    public List<Student> find(@PathVariable String name) {
        return studentService1.find(name);
    }
}
