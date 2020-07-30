package com.example.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @program: data-jpa
 * @description: ${配置JPA注解配置映射关系
 * 1、@Entity JPA实体类和数据库表映射的类
 * 2、@Table(name="tbl_user") 指定数据库对应表 如果省略 表名就是类名小写
 * 3、@Column 省略默认列名就是属性名
 * 4、@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
 *    处理因为部分没有值引发的序列化异常
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-07-30 22:01
 **/
@Entity
@Table(name="tbl_user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column(name="email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
