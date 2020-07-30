package com.example.datajpa.repository;

import com.example.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: data-jpa
 * @description: ${DAO 1、统一Repository 继承JPARepository实现CRUDJ及分页}
 * @author: Mr.ZeroCamel
 * @create: 2020-07-30 22:10
 **/
public interface UserRepository extends JpaRepository<User,Integer> {

}
