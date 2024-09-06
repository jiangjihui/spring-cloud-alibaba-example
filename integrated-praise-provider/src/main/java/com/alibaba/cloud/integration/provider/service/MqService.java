package com.alibaba.cloud.integration.provider.service;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * MqService
 *
 * @author jiangjihui
 * @date 2024/08/31
 **/
@Service
public class MqService {

    public void testmq()  {

        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();
            Message msg = new Message("test-topic", "tagStr", "message from rocketmq producer".getBytes());
            producer.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
