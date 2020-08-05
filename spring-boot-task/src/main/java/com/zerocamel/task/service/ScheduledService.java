package com.zerocamel.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-task
 * @description: 定时任务
 * @author: zeroCamel
 * @create: 2020-08-05 14:09
 **/
@Service
public class ScheduledService {

    @Scheduled(cron = "0 * * * * MON-SAT")
    public void helloSchedule()
    {
        System.out.println("定时任务执行中...");
    }
}
