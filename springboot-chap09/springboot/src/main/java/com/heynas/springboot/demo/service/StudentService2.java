package com.heynas.springboot.demo.service;

import com.heynas.springboot.demo.core.PersistenceManager;
import com.heynas.springboot.demo.dao.StudentJpaRepository;
import com.heynas.springboot.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class StudentService2 {
    @Autowired
    PersistenceManager persistenceManager;

    public String add(Student student) {
        persistenceManager.add(student);
        return student.getUuid();
    }
}
