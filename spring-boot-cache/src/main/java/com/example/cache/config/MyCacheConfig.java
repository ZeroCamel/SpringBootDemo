package com.example.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: spring-boot-cache
 * @description: ${自定义缓存Key生成规则}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-02 16:36
 **/
@Configuration
public class MyCacheConfig {

    @Bean
    public KeyGenerator myKeyGenerator()
    {
       return  new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+'['+ Arrays.asList(objects).toString()+']';
            }
        };
    }
}
