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

2. Publish/Subscribe 发布订阅

3. Routing 路由

4. Topics 通配符

5. Header Header转发器

6. RPC 远程调用

