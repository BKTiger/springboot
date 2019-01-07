package com.rabbitmq.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangtai
 * @date 2019/1/7 07:01
 * @Description:
 */
public class producer {

    public static void main(String[] args) {
        //通过链接工厂创建链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.117.188");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //设置虚拟机,一个mq服务可以设置多个虚拟机,每个虚拟机相当于一个独立的ma
        connectionFactory.setVirtualHost("/");
        //建立新连接
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
