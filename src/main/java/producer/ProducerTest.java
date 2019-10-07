package producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IVAN_KIM
 */


/**
 * MQ启动命令
 * start mqnamesrv.cmd
 * start mqbroker.cmd -n localhost:9876
 */


public class ProducerTest {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("my-group-name-A");

        producer.setNamesrvAddr("localhost:9876");

        producer.start();



        Message message = new Message("topic-name-A","tag-name-A","Message : My blog address guozh.net".getBytes());


        producer.send(message);
        System.out.println("Message sended" );

        producer.shutdown();



    }

}
