package com.example.cache.service;

import com.example.cache.bean.Department;
import com.example.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(value = "dept")
    public Department getDeptById(Integer id)
    {
        return departmentMapper.getDeptById(id);
    }
}
