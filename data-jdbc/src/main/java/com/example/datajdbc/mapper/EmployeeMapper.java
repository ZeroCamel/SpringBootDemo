package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//指定操作数据的mapper
//1、配置版Mapper
//@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public void insertEmp(Employee employee);
}
