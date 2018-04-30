package com.heynas.springboot.demo.service;

import com.heynas.springboot.demo.dao.StudentJpaRepository;
import com.heynas.springboot.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * <p> Description:  StudentService </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Service
@Transactional
public class StudentService1 {
    @Autowired
    StudentJpaRepository jpaRepository;

    public String add(Student student) {
        jpaRepository.save(student);
        return student.getUuid();
    }

    public Student findByPk(String uuid) {
        return jpaRepository.findOne(uuid);
    }

    public void delete(String uuid) {
        jpaRepository.delete(uuid);
    }

    public void deleteAll() {
//        String strSql = "delete from student";
        jpaRepository.deleteAll();
//        jdbcTemplate.update(strSql);
    }

    public List<Student> find(String name) {
        return jpaRepository.findByNameEquals(name);
    }
}
