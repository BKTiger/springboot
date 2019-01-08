package com.rabbitmq.base;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangtai
 * @date 2019/1/7 22:56
 * @Description:
 * 总结:
 * 1. 创建连接
 * 2. 创建通道
 * 3. 声明队列
 * 4. 监听队列
 * 5. 接受消息
 * 6. ack回复
 */
public class Consumer {

    //队列名称
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) throws Exception {
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
        connection = connectionFactory.newConnection();
        //创建会话通道,生产者和mq服务器所有的通信都在channel通道中完成
        Channel channel = connection.createChannel();

        //监听队列
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

        //实现消费方法
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            //当接收到消息后,此方法被调用
            /* *
             * @param: [consumerTag, envelope, properties, body]
             * consumerTag:消费者标签,用来标识消费者,可不设置,可以在监听队列时设置 channel.basicConsume
             * envelope 信封,通过envelope
             * properties 消息的属性
             * body 消息内容
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //获取交换机
                String exchange = envelope.getExchange();
                //消息id,mq在channel中标识消费的id,作用:可用于确认消息已接收
                long deliveryTag = envelope.getDeliveryTag();
                //消息内容
                String message = new String(body,"utf-8");
                System.out.println("receive message: " + message);
            }
        };

        //监听队列
        /* *
         * 参数:String queue, boolean autoAck, Consumer callback
         * queue:队列名称
         * autoAck:自动回复,当消费者接收到消息后,要告诉mq,消息已接收,如果将此参数设置为true,则会自动回复ma已收到信息,如果不回复,则消息队列中的消息一直存在
         * callback:消费方法,当消费者接收到消息需要执行的方法
         */
        channel.basicConsume(QUEUE,true,defaultConsumer);
    }
}
