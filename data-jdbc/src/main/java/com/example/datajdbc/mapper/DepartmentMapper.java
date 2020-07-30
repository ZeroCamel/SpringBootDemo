package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.Department;
import org.apache.ibatis.annotations.*;

//指定操作数据的mapper
// 1、注解版Mapper 或者在程序主入口增加MapperScan批量扫描
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
