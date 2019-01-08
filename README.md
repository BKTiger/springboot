# springboot
各种框架的整合案例
#### rabbitMQ入门
1. 安装rabbitMQ
2. 导入jar包
```
<dependency>
	<groupId>com.rabbitmq</groupId>
	<artifactId>amqp-client</artifactId>
	<version>4.0.3</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```
3. 工作原理
![rabbitMQ原理](picture/rabbitMQ原理.png)
#### rabbitMQ基础案例
```
生产者:com.rabbitmq.base.Producer
消费者:com.rabbitmq.base.Consumer
```
#### 工作模式
1. Work Queues 工作队列

![rabbitMQ原理](picture/work queues.png)

2. Publish/Subscribe 发布订阅

![rabbitMQ原理](picture/Publish--Subscribe.png)

3. Routing 路由

![rabbitMQ原理](picture/Routing.png)

4. Topics 通配符

![rabbitMQ原理](picture/Topics.png)

5. Header Header转发器

6. RPC 远程调用

![rabbitMQ原理](picture/RPC.png)

#### 工作队列模式(Work Queues)

测试程序：程序和入门程序一致，

1. 将消费者打开多个；
 
2. 使用生产者多次发送数据；

3. 消费者以默认轮询的方式接收数据；

#### 发布订阅模式(Publish/Subscribe)
```
生产者:com.rabbitmq.publishsubscribe.Producter
消费者:com.rabbitmq.publishsubscribe.ConsumerEmall
消费者:com.rabbitmq.publishsubscribe.ConsumerSms
```

- 发布订阅的每一个分支都相当于一个工作队列模式

#### 路由模式(Routing) 

1. 说明:

- 一个交换机绑定多个队列,每个队列设置routingkey,并且一个队列可以设置多哥routingkey

- 每个消费者监听自己的队列

- 生产者将消息发给交换机,发送消息时需要制定routingkey的值,交换机来判断该routingkey的值和哪个队列的routingkey相等,如果相等则将消息发送到该队列

2. 测试实现:
```

```
