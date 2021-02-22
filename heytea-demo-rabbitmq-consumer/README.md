### 准备好 RabbitMQ

业务子系统使用的对应 RabbitMQ 队列如下： 

- OA 系统： heytea.sso.oa.queue
- E-Learning 系统： heytea.sso.elearning.queue

### 启动服务

```
mvn clean spring-boot:run
```

### 测试

打开 RabbitMQ 的管理后台，在队列： heytea.sso.oa.queue 上可以在用下面的数据进行测试：

```
Properties 设置:
content_encoding: UTF-8
content_type: application/json

Payload 数据设置：
{"biz":"heytea.sso.002","uid":"0B4732D3F1B...","timestamp":1602733893000,"data":{"id":"xxxxx","loginid":"xxx","sex":"female","status":123333,"msg":"test message."}}
```

控制台回输出日志。
