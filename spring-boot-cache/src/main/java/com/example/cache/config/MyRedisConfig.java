package com.example.cache.config;

import com.example.cache.bean.Department;
import com.example.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * @Author zeroCamel
 * 1、修改默认RedisTemplate序列化机制
 * 2、自定义CacheManager传入修改后的Template
 */
@Configuration
public class MyRedisConfig {

    /**
     * 操作员工的Template
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object,Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //修改默认JDK序列化器
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 针对员工的缓存管理器，如果是部门则会出现序列化成功，反序列失败的问题
     * @param redisConnectionFactory
     * @return
     */
    @Primary
    @Bean
    public RedisCacheManager employeeCacheManager(RedisConnectionFactory redisConnectionFactory)
    {
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(30))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheManager cacheManager = RedisCacheManager
                .builder(redisConnectionFactory).cacheDefaults(cacheConfiguration).build();
        return cacheManager;
    }


    /**
     * 操作部门的Template
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object,Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //修改默认JDK序列化器
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 针对部门的缓存管理器
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager deptCacheManager(RedisConnectionFactory redisConnectionFactory)
    {
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(30))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheManager cacheManager = RedisCacheManager
                .builder(redisConnectionFactory).cacheDefaults(cacheConfiguration).build();
        return cacheManager;
    }

}
