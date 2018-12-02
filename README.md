# springboot
## mongodb框架的整合
1. 在配置文件中配置mongodb的链接路径
```
spring.data.mongodb.uri=mongodb://zhangtai:123456@192.168.117.188:27017
spring.data.mongodb.database=mongodb_test
```
2. 继承类MongoRepository即可获取操作mongodb数据库的方法
