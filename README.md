# springboot

各种框架的整合案例

#### 整合mybatis-xml

1. 导入jar包
```
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>1.1.1</version>
</dependency>
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
</dependency>
```

2. 配置
```
spring.datasource.url = jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf-8
spring.datasource.username = root
spring.datasource.password = root

mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```

3. 给JAVA的mapper文件加上注释@Mapper
