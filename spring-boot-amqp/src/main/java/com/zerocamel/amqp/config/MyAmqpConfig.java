package com.zerocamel.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义AMQP序列化
 */
@Configuration
public class MyAmqpConfig {

    @Bean
    public MessageConverter myConvert()
    {
        return new Jackson2JsonMessageConverter();
    }
}
