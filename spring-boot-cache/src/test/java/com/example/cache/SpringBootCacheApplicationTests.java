package com.example.cache;

import com.example.cache.bean.Employee;
import com.example.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * Redis操作5大数据类型
     * String List Set ZSet Hash
     *
     */
    @Test
    public void test01()
    {
        stringRedisTemplate.opsForValue().append("msg","ffff");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mylist","2");


    }

    /**
     * 测试保存对象
     */
    @Test
    public void test02()
    {
        Employee empById = employeeMapper.getEmpById(1);
        // 默认保存对象，使用JDK序列化机制，序列化后的数据保存到Redis中
        //redisTemplate.opsForValue().set("emp-02",empById);
        //1、将数据以json的方式保存
        employeeRedisTemplate.opsForValue().set("emp-01",empById);
    }


    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
