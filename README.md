# 青柠账本(服务端)
软件工程团队实践作业   
安卓端：https://github.com/lns103/Bookkeeping-android

数据库连接配置文件 src/main/resources/application.yml   
示例：
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8
    username: xxxx
    password: xxxx
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:xyz/lns103/mybatisplus/mapper/xml/*.xml
server:
  port: xxxx
  address: 127.0.0.1
```
