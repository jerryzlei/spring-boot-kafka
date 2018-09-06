package com.qudian.kafka.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-07 下午3:24
 **/
@Slf4j
//@Component
public class SystemUserListener2 {
    @Autowired
    List<KafkaListenerContainerFactory> factories;

    @KafkaListener(topics = {"${kafka_topic_example}"},group = "group_two",containerFactory = "group_two")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("Listener2: topic:{}, group:{},key:{},value:{}","group_two",record.topic(), record.key(),record.value().toString());
    }
}
