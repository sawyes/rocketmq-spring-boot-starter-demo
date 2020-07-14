# Rocketmq-demo

## install

https://github.com/apache/rocketmq-docker

## config

you need modify config
```
mybatis: user/password
rocketmq: name-server
```

## demo

```
curl 127.0.0.1:9091/user/list

--- TopicTest2 result :SendResult [sendStatus=SEND_OK, msgId=C0A8015CAD0318B4AAC24577B4960000, offsetMsgId=7A33AB8B00002A9F000000000054B52F, messageQueue=MessageQueue [topic=TopicTest, brokerName=broker-a, queueId=0], queueOffset=250]
===> BROADCASTING1: [{"payload":"{\"createdAt\":1593356748000,\"id\":1,\"name\":\"peter\",\"updatedAt\":1593358289000}","headers":{"KEYS":"KEY_1","id":"659fbf52-bdad-f16c-3701-358ba7a84f87","timestamp":1594698267824}}]
===> AsynConsumer: [{"payload":"{\"createdAt\":1593356748000,\"id\":1,\"name\":\"peter\",\"updatedAt\":1593358289000}","headers":{"KEYS":"KEY_1","id":"659fbf52-bdad-f16c-3701-358ba7a84f87","timestamp":1594698267824}}]
===> BROADCASTING2 [{"payload":"{\"createdAt\":1593356748000,\"id\":1,\"name\":\"peter\",\"updatedAt\":1593358289000}","headers":{"KEYS":"KEY_1","id":"659fbf52-bdad-f16c-3701-358ba7a84f87","timestamp":1594698267824}}]
```

