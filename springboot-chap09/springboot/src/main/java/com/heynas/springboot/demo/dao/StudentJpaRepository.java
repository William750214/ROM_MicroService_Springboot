package com.heynas.springboot.demo.dao;

import com.heynas.springboot.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p> Description:  StudentJpaRepository </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
public interface StudentJpaRepository extends JpaRepository<Student,String>{
    List<Student> findByNameEquals(String name);

    List<Student> findByAgeAfter(Integer age);
}
