package com.heynas.springboot.demo.service;

import com.heynas.springboot.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
public class StudentService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String add(Student student) {
        em.persist(student);
        return student.getUuid();
    }

    public Student findByPk(String uuid) {
        return em.find(Student.class, uuid);
    }

    public void deleteAll() {
        String strSql = "delete from student";
        jdbcTemplate.update(strSql);
    }
}
