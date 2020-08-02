package com.example.cache.service;

import com.example.cache.bean.Employee;
import com.example.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: spring-boot-cache
 * @description: ${@CacheConfig 抽取缓存公共配置}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-01 16:37
 **/
//@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
    * @Description: ${将方法的结果进行缓存SpEl表达式
     * key获取 #id #a0 #p0 #root.arg[0]
     * value/cachenames 缓存值
     * unless 条件满足不缓存
     * sync 使用异步模式 默认同步 方法执行之后缓存 但是不支持Unlesss
     * }$
    * @Param: [id]
    * @return: com.example.cache.bean.Employee
    * @Author: Mr.ZeroCamel
    * @Date: 2020/8/1
    */
    //@Cacheable(cacheNames = {"emp"},key = "#root.methodName+'['+#id+']'")
    //@Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator",condition = "#p0>1 and #root.methodName eq 'aaa'",unless = "#a0=2")
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmployee(@PathVariable Integer id)
    {
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    /**
     * @CachePut 既调用方法又更新缓存Key
     * 修改了数据库某个值 同时更新缓存
     * 1、从参数中获取 #employee.id
     * 2、从结果中获取 #result.id
     */
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmployee(Employee employee)
    {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict 缓存清除
     * allEntries = true 删除缓存组件所有的KEY
     * beforeInvocation = true 默认在方法执行后执行，如果方法报错不会清空缓存
     *      如果在方法执行前清空缓存，不会受缓存的影响
     *
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmployee(Integer id)
    {
        System.out.println("delete employee"+id);
        //employeeMapper.deleteEmp(id);
    }

    /**
     * @Caching 定义复杂的缓存规则，缓存多个Key值对象
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName)
    {
        return employeeMapper.getEmpByLastName(lastName);
    }

}
