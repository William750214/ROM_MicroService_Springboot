package com.heynas.springboot.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p> Description:  Student </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Entity
@Table(name = "student")
@ApiModel(value= "返回Student对象")
public class Student implements Serializable{
    @Id
    @Column(name = "uuid", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;
    @ApiModelProperty(value = "姓名")
    @Column(name = "name", unique = false, nullable = true, length = 256)
    private String name;
    @ApiModelProperty(value = "年龄")
    @Column(name = "age", precision = 9)
    private Integer age;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
