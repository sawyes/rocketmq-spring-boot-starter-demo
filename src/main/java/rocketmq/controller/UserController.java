package rocketmq.controller;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocketmq.dao.UserMapper;
import rocketmq.model.User;
import org.springframework.messaging.Message;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/list")
    public List<User> list() {

        List<User> users = userMapper.selectAll();

        List<Message> messages = new ArrayList<Message>();

        for (User user : users) {

            messages.add(MessageBuilder.withPayload(JSON.toJSONString(user)).
                    setHeader(RocketMQHeaders.KEYS, "KEY_" + user.getId()).build());

        }

        SendResult sync_topic = rocketMQTemplate.syncSend("TopicTest", messages);

        System.out.println("--- TopicTest2 result :" + sync_topic);

        return users;
    }

    
}
