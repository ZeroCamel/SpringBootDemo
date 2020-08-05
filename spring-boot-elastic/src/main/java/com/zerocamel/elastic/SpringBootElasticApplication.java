package com.zerocamel.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 默认使用两种技术操作ES
 * 1、SpringData ElasticSearch
 * 2、Jest deprecated
 * 3、React
 */
@SpringBootApplication
public class SpringBootElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticApplication.class, args);
    }

}
