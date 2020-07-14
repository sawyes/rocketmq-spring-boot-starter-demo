package rocketmq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 同步消息
 */
@Service
@RocketMQMessageListener(consumerGroup = "rocketmq-group", topic = "TopicTest")
public class AsynConsumer implements RocketMQListener<MessageExt> {

    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        System.out.println("===> AsynConsumer: " + new String(body));
    }
}