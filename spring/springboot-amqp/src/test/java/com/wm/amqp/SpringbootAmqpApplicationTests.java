package com.wm.amqp;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchage(){
        amqpAdmin.declareExchange(new DirectExchange(("amqpAdmin.exchange")));
        System.out.println("ssssssssss");
    }

    @Test
    void contextLoads() {

        Message message = new Message("sssss".getBytes(),new MessageProperties());

        rabbitTemplate.send("exchange.direct","atguigu.news", message);
    }

    @Test
    public void receive(){
        Object object = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(object.getClass());
        System.out.println(object);
    }

}
