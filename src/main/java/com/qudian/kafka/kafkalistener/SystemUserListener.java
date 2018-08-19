package com.qudian.kafka.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-07 下午3:24
 **/
@Slf4j
@Component
public class SystemUserListener {

    @KafkaListener(topics = {"${kafka_topic_example}"},group = "default_group")
    public void listen(ConsumerRecord<?, ?> record) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Listener1: topic:{}, group:{},key:{},value:{}","default_group",record.topic(), record.key(),record.value().toString());
    }
}
