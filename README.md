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

#### 整合pageHelper

1. 导入jar包.使用1.2.2版本会报错

```
<dependency>
  <groupId>com.github.pagehelper</groupId>
  <artifactId>pagehelper-spring-boot-starter</artifactId>
  <version>1.2.3</version>
</dependency>
```
2. 在配置文件中加入方言配置

```
pagehelper.helper-dialect=mysql
```

3. 写sql时不用写分页语句
```
PageHelper.startPage(Integer.parseInt(param.get("page").toString()),Integer.parseInt(param.get("pageSize").toString()));
Page<Student> page = indexMapper.page();
long total = page.getTotal();
```
