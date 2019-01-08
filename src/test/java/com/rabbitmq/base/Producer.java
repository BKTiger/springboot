package com.rabbitmq.base;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangtai
 * @date 2019/1/7 07:01
 * @Description:
 * 总结
 * 1. 创建连接
 * 2. 创建通道
 * 3. 声明队列
 * 4. 发送消息
 */
public class Producer {

    //队列名称
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) {
        //通过链接工厂创建链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.117.188");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq服务可以设置多个虚拟机,每个虚拟机相当于一个独立的mq
        connectionFactory.setVirtualHost("/");
        //建立新连接
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
            //创建会话通道,生产者和mq服务器所有的通信都在channel通道中完成
            channel = connection.createChannel();
            //声明队列:如果队列在MQ当中没有,则需要创建
            /* *
             * 参数:String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
             * 参数明细：
             * 1.String queue 队列名称
             * 2.boolean durable 是否持久化.持久化后则队列还在
             * 3.boolean exclusive 是否排他.是否独占链接,队列只允许在该链接访问,如果链接关闭,则队列自动删除,如果将参数设置true,可用于临时队列的创建
             * 4.boolean autoDelete 不再使用时自动删除队列.如果将此参数和exclusive参数设置为true,则实现临时队列的创建
             * 5.arguments 可以设置队列的扩展参数.例如:可以设置存活时间
             */
            channel.queueDeclare(QUEUE,true,false,false,null);
            //发送消息
            /* *
             * 参数:String exchange, String routingKey, BasicProperties props, byte[] body
             * 1. String exchange:交换机,如果不指定,则使用默认交换机(设置为"")
             * 2. routingKey 路由key,交换机根据路由key将消息转发到指定队列,如果使用模式交换机,则将其设置为队列名称
             * 3. props 消息的属性
             * 4. 消息内容
             */
            //定义一个消息内容
            String message = "hello world";
            channel.basicPublish("",QUEUE,null,message.getBytes());
            System.out.println("send to mq "+message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            //先关闭通道
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            //在关闭链接
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
