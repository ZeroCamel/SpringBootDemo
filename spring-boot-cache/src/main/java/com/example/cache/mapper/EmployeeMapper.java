package com.example.cache.mapper;

import com.example.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @Author zeroCamel 指定Mapper
 */
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE ID=#{id}")
    public void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
