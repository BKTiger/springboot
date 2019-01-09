package com.zhangtai.demo.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangtai
 * @date 2019/1/10 06:45
 * @Description:
 */
@Configuration
public class RabbitmqConfig {

    //队列名称
    public static final String QUEUE_INFORM_EMALL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    //交换机名称
    public static final String EXCHAGE_TOPICS_INFORM = "exchange_topics_inform";
    //routingkey的名称
    public static final String ROUTINGKEY_EMALL = "inform.#.emall.#"; //匹配inform.emall.sms或inform.emall
    public static final String ROUTINGKEY_SMS = "inform.#.sms.#";//匹配inform.emall.sms或inform.sms

    //声明交换机
    @Bean(EXCHAGE_TOPICS_INFORM)
    public Exchange EXCHAGE_TOPICS_INFORM(){
        //durable(true) 持久化,mq重启后交换机还在
        return ExchangeBuilder.topicExchange(EXCHAGE_TOPICS_INFORM).durable(true).build();

    }
    //声明队列
    @Bean(QUEUE_INFORM_EMALL)
    public Queue QUEUE_INFORM_EMALL(){
        return new Queue(QUEUE_INFORM_EMALL);
    }

    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS(){
        return new Queue(QUEUE_INFORM_SMS);
    }
    //绑定交换机和队列
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMALL(@Qualifier(QUEUE_INFORM_EMALL) Queue queue,
                                              @Qualifier(EXCHAGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMALL).noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                              @Qualifier(EXCHAGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }
}
