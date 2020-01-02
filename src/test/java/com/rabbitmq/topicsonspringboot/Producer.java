package com.rabbitmq.topicsonspringboot;

import com.zhangtai.demo.DemoBootApplication;
import com.zhangtai.demo.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangtai
 * @date 2019/1/10 07:01
 * @Description:
 */
@SpringBootTest(classes = {DemoBootApplication.class})
@RunWith(SpringRunner.class)
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSendEmall(){

        String message = "send email message to user";
        /**
         * 参数
         * 1. 交换机名称
         * 2. routingkey名称
         * 3. 消息
         */
        rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_INFORM_EMALL,message);
    }
}
