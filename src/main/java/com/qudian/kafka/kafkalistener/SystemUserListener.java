package com.qudian.kafka.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-07 下午3:24
 **/
@Slf4j
@Component
public class SystemUserListener {

    @KafkaListener(topics = {"${kafka_topic_example}"},containerFactory="kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        log.info(record);
        log.info("Listener1: topic:{}, group:{},key:{},value:{},offset:{}","default_group",record.topic(), record.key(),record.value().toString(),record.offset());
        acknowledgment.acknowledge();
    }
}
