package com.gz.manager.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年03月22日<br>
 */
@Component
public class KafkaProducerHelper {

    private KafkaProducer<String, String> kafkaProducer;

    public KafkaProducerHelper(){
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        //acks 指定了必须要有多少个分区副本接收到消息，生产者才会认为消息写入是成功的
        properties.setProperty("acks", "all");
        //该参数决定了生产者可以重发消息的次数，如果达到这个次数，生产者会放弃重试并返回错误
        properties.setProperty("retries", "0");
        //改参数指定了一个批次可以使用的内存的大小
        properties.setProperty("batch.size", "16384");
        //该参数指定了生产者在发送批次之前等待更多消息加入批次的时间
        properties.setProperty("linger.ms", "1");
        //该参数用来设置生产者内存缓冲区大小，生产者用它缓冲要发送到服务器的消息
        properties.setProperty("buffer.memory", "33554432");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.kafkaProducer = new KafkaProducer<String, String>(properties);
    }

    public KafkaProducerHelper(Map<String, Object> configs){
        this.kafkaProducer = new KafkaProducer<String, String>(configs);
    }

    public KafkaProducer getKafkaProducer(){
        return kafkaProducer;
    }
}
