package rocketmq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 异步消息
 */
@Service
@RocketMQMessageListener(
        consumerGroup = "TopicTest2",
        topic = "TopicTest",
        // selectorExpression = "order",  // tag default is '*'
        consumeMode = ConsumeMode.CONCURRENTLY,
        messageModel = MessageModel.BROADCASTING
)
public class BroadcastConsumer2 implements RocketMQListener<MessageExt> {

    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        System.out.println("===> BROADCASTING2 " + new String(body));
    }

}