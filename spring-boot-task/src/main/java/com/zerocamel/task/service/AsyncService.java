package com.zerocamel.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-task
 * @description: 服务层
 * @author: zeroCamel
 * @create: 2020-08-05 13:43
 **/
@Service
public class AsyncService {

    @Async
    public void test()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中...");
    }
}
