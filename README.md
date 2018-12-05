# springboot
各种框架的整合案例
### 规范返回类型和统一异常处理
1. 规范返回类型
    * ResultCode 枚举类继承的接口
        * impl  枚举类型的实现类
    * Result 承载枚举类的接口
    * DataResult 返回的数据
    * ResponseResult 统一带数据返回类型
    
2. 统一异常处理
    * CommonException 自定义异常
    * ExceptionCast 工具类
    * ExceptionCatch 捕捉异常的控制类增强器(重点)

3. ImmutableMap类的使用
    * ImmutableMap是不可变的，线程安全的；它可以创建一些常量的映射键值对