package consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author IVAN_KIM
 */
public class ConsumerTest {

    public static void main(String[] args) throws MQClientException {

        //这里填写group名字

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-group-name-A");

        //NameServer地址

        consumer.setNamesrvAddr("localhost:9876");

        //1：topic名字 2：tag名字

        consumer.subscribe("topic-name-A", "tag-name-A");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override

            public ConsumeConcurrentlyStatus consumeMessage(

                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }

        });

        consumer.start();

        System.out.println("Consumer Started!");

    }

}


