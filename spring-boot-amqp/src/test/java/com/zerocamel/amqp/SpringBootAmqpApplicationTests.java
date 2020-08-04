package com.zerocamel.amqp;

import com.zerocamel.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange()
    {
        //创建交换机
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //创建队列
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
        //绑定
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","zerocamel",null));
    }


    /**
     * 1、单播 点对点
     * 2、多播 更换对应的交换器即可
     */
    @Test
    void contextLoads() {

        //Message可以自定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routingKey,message);

        //object默认当成消息体，只需要传入要需要的对象，自动序列化rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routingKey,object);

        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是一个消息");
        map.put("data", Arrays.asList("hello,word",123,true));

        Book book = new Book("水浒城", "施耐庵");

        rabbitTemplate.convertAndSend("exchange.direct","zerocamel.news",book);

    }


    /**
     * 接收消息队列的消息
     */
    @Test
    public void recieve()
    {
        Object zerocamel = rabbitTemplate.receiveAndConvert("zerocamel.news");
        System.out.println(zerocamel.getClass());
        System.out.println(zerocamel);
    }



}
