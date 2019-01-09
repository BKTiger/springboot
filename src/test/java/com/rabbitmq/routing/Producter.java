package com.rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangtai
 * @date 2019/1/8 22:08
 * @Description:
 * 总结
 * 1. 创建连接
 * 2. 创建通道
 * 3. 声明队列
 * 4. 声明交换机
 * 5. 绑定队列和交换机
 * 6. 发送消息
 */
public class Producter {
    //队列名称
    private static final String QUEUE_INFORM_EMALL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    //交换机名称
    private static final String EXCHAGE_ROUTING_INFORM = "exchange_routing_inform";
    //routingkey的名称
    private static final String ROUTINGKEY_EMALL = "inform_emall";
    private static final String ROUTINGKEY_SMS = "inform_sms";

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
            channel.queueDeclare(QUEUE_INFORM_EMALL,true,false,false,null);
            channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);
            //声明交换机
            /* *
             * 参数:String exchange, String type
             * 1. exchange:交换机的名称
             * 2. type:交换机类型
             *      fanout:对应的rabbitmq的模式是:publish/subscribe(发布订阅模式)
             *      direct: 对应的rabbitmq的模式是:Routing(路由模式)
             *      topic: 对应的rabbitmq的模式是:topic(通配符模式)
             *      headers:对应的rabbitmq的模式是:headers(headers模式)
             *
             */
            channel.exchangeDeclare(EXCHAGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);

            //进行交换机和队列的绑定
            /* *
             * 参数:String queue, String exchange, String routingKey
             * 1. queue:队列名称
             * 2. exchange:交换机名称
             * 3. routingKey:路由key,在发布订阅模式中设置为空字符串.作用:交换机根据路由key的值将详细转发到指定的队列
             */
            channel.queueBind(QUEUE_INFORM_EMALL,EXCHAGE_ROUTING_INFORM,ROUTINGKEY_EMALL);
            channel.queueBind(QUEUE_INFORM_SMS,EXCHAGE_ROUTING_INFORM,ROUTINGKEY_SMS);

            //发送消息
            /* *
             * 参数:String exchange, String routingKey, BasicProperties props, byte[] body
             * 1. String exchange:交换机,如果不指定,则使用默认交换机(设置为"")
             * 2. routingKey 路由key,交换机根据路由key将消息转发到指定队列,如果使用模式交换机,则将其设置为队列名称
             * 3. props 消息的属性
             * 4. 消息内容
             */
            //定义一个消息内容
            for(int i=0;i<5;i++){
                //发送消息指定routingkey
                String message = "send inform message to user";
                channel.basicPublish(EXCHAGE_ROUTING_INFORM,ROUTINGKEY_EMALL,null,message.getBytes());
                System.out.println("send to mq "+message);
            }

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
