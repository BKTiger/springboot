package com.rabbitmq.topicsonspringboot;

import com.zhangtai.demo.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhangtai
 * @date 2019/6/5 0005 14:58
 * @Description:
 */
@Component()
@RabbitListener(queues = RabbitmqConfig.QUEUE_INFORM_EMALL)
public class ConsumerTest {

    @RabbitHandler
    public void PrintLog(String msg) {
        System.out.println("我是消息接收者:打印" + msg);

    }
}
