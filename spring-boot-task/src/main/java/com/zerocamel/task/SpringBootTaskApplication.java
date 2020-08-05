package com.zerocamel.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author zeroCamel
 * 1、EnableAsync 开启异步注解功能
 * 2、EnableScheduling 开启调度功能
 *    cors 表达式0-7周日 与Quarts 1 周日 2 周一
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringBootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class, args);
    }

}
