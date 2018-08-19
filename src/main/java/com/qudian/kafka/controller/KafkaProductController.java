package com.qudian.kafka.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-07 上午11:39
 **/

@Controller
@RequestMapping("kafka")
@Api(tags = "kafka发送消息")
public class KafkaProductController {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka_topic_example}")
    private String kafkaTopicExample;

    @ApiOperation("seng kafka MQ")
    @RequestMapping(value = "/sendMq")
    public ResponseEntity<String> send(@RequestParam(value = "count") long count){
        try {
            for(int i = 0 ; i < count ; i++){
                String key = count + "";
                String content = key + " :content" ;
                kafkaTemplate.send(kafkaTopicExample,key , content);
            }
            return ResponseEntity.ok("发送topic="+ kafkaTopicExample +"数据成功");
        }catch (Exception e){
            return ResponseEntity.ok("发送topic="+ kafkaTopicExample +"数据失败");
        }
    }
}
