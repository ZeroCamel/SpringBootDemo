package com.example.cache.controller;

import com.example.cache.bean.Department;
import com.example.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.ZeroCamel
 */
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDeptmentById(@PathVariable("id") Integer id)
    {
        Department department = deptService.getDeptById(id);
        return department;
    }
}
