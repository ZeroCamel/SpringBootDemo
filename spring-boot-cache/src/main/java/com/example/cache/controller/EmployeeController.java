package com.example.cache.controller;

import com.example.cache.bean.Employee;
import com.example.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-cache
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-01 17:03
 **/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id)
    {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee)
    {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return  updateEmployee;
    }

    @GetMapping("/deleteEmp")
    public String delete(Integer id)
    {
        employeeService.deleteEmployee(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName)
    {
        Employee empByLastName = employeeService.getEmpByLastName(lastName);
        return empByLastName;
    }
}
