# springboot
各种框架的整合案例

### spring监听事件

1. spring 框架加载完后执行的代码
```java
com.zhangtai.demo.littleDog.AfterSpring
```
2. 添加监听事件
```java
com.zhangtai.demo.index.IndexController;
com.zhangtai.demo.index.IndexEvent;
com.zhangtai.demo.index.SmsListener;
```

-----------

### 加入运行状态监控actuator

1.  引入依赖
```aidl
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```
2. 加入如下配置,暴露actuator所有接口
   ```aidl
   management.endpoints.web.exposure.include=*
   ```
3. http://server:port/actuator 显示所有可用的监控接口

  Endpoint ID | Description 
   ---|---
   auditevents | 显示应用暴露的审计事件 (比如认证进入、订单失败)
   info |   显示应用的基本信息
   health | 显示应用的健康状态
   metrics | 显示应用多样的度量信息
   loggers | 显示和修改配置的loggers
   logfile| 返回log file中的内容(如果logging.file或者logging.path被设置)
   httptrace | 显示HTTP足迹，最近100个HTTP request/repsponse
   env | 显示当前的环境特性
   flyway | 显示数据库迁移路径的详细信息
   liquidbase | 显示Liquibase 数据库迁移的纤细信息
   shutdown|让你逐步关闭应用
   mappings| 显示所有的@RequestMapping路径
   scheduledtasks | 显示应用中的调度任务
   threaddump|执行一个线程dump
   heapdump|返回一个GZip压缩的JVM堆dump

### converter入参字段格式化

1. 主要用于字段去空，日期格式化

2. 代码位置

   ```java
   com.zhangtai.demo.filter.WebAppConfiguration
   com.zhangtai.demo.filter.StringToDateConverter
   // 测试代码位置
   com.zhangtai.demo.index.IndexController#showIndex(java.util.Date, java.lang.String)
   ```

   

### BeanFactoryPostProcess扩展练习

1. 代码位置

   ```java
   com.zhangtai.demo.config.beanfactorypostprocesstest.MyBeanFactoryPostProcess
   ```

   

### 继承关系requestMapping验证

1. 如果只有抽象类,则无法请求到路径
2. 实现类里的RequestMapping会覆盖父类

