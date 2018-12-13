# springboot
## mongodb框架的整合
1. 在配置文件中配置mongodb的链接路径
```
spring.data.mongodb.uri=mongodb://zhangtai:123456@192.168.117.188:27017
spring.data.mongodb.database=mongodb_test
```
2. 继承类MongoRepository即可获取操作mongodb数据库的方法

3. 2018-12-13加入GridFS上传下载文件的支持  
  注意在下载文件时加入了mongodb的配置java用于打开下载流对象
