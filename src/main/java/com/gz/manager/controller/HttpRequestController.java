package com.gz.manager.controller;

import com.gz.manager.kafka.KafkaComsumerHelper;
import com.gz.manager.kafka.KafkaProducerHelper;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.protocol.types.Field;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.*;

@RestController
@RequestMapping("/api/v1.0")
public class HttpRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServletRequest.class);


    @Autowired
    private KafkaProducerHelper kafkaProducerHelper;

    @Autowired
    private KafkaComsumerHelper kafkaComsumerHelper;

    @RequestMapping("/product")
    public String product() {

        KafkaProducer<String, String> producer = kafkaProducerHelper.getKafkaProducer();

        ProducerRecord<String, String> record = new ProducerRecord("test", "2019-5-15");

        producer.send(record);

        return "product 1 record";
    }
    @RequestMapping("/comsumer")
    public String comsumer() {

        KafkaConsumer<String, String> consumer = kafkaComsumerHelper.getKafkaConsumer();

        //订阅名字为test的topic
        consumer.subscribe(Collections.singletonList("test"));

        Map<String, Integer> custCountryMap = new HashMap<String, Integer>();

        int updatedCount = 1;

        //消费者开机时就启动，一直轮询消费

        try {
            //消费者是一个长期运行的程序，通过持续轮询向Kafka请求数据。在其他线程中调用consumer.wakeup()可以退出循环
            //在100ms内等待Kafka的broker返回数据.超时参数指定poll在多久之后可以返回，不管有没有可用的数据都要返回
            Duration duration = Duration.ZERO;

            ConsumerRecords<String, String> records = consumer.poll(10);
            LOGGER.error("waiting...");
            LOGGER.error(records.toString());
            for (ConsumerRecord<String, String> record : records) {
                LOGGER.error(record.topic() + record.partition() + record.offset() + record.key() + record.value());
                //统计各个地区的客户数量，即模拟对消息的处理

                LOGGER.error("record.value : {}", record.value());
                //真实场景中，结果一般会被保存到数据存储系统中
                JSONObject json = new JSONObject(custCountryMap);
                System.out.println(json.toString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出应用程序前使用close方法关闭消费者，网络连接和socket也会随之关闭，并立即触发一次再均衡
            consumer.close();
        }

        return "comsumer finished, count: " + updatedCount;
    }

    @RequestMapping("/concumser_test")
    public String consumer_test(HttpServletRequest request){
        KafkaConsumer<String, String> consumer = kafkaComsumerHelper.getKafkaConsumer();

        //订阅主题为test
        consumer.subscribe(Collections.singletonList("test"));

        try {
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records){
                    LOGGER.info("topic = {}, partition = {}, offset = {}, consumer = {}, value = {}", record.topic(),
                            record.partition(), record.offset(), record.key(), record.value());
                }

               /* try {
                    //同步提交，在broker对提交请求作出回应之前，应用程序会一直堵塞
                    consumer.commitSync();
                }catch (CommitFailedException e){
                    LOGGER.error("commit error");
                }*/

               consumer.commitAsync();
            }
        }
        finally {
            try {
                consumer.commitSync();
            }finally {
                consumer.close();
            }
        }
    }

    @RequestMapping("/concumser_test1")
    public String consumer_test1(HttpServletRequest request){
        KafkaConsumer<String, String> consumer = kafkaComsumerHelper.getKafkaConsumer();

        List<PartitionInfo> partitionInfos = null;

        partitionInfos = consumer.partitionsFor("topic");

        List<TopicPartition> list = new ArrayList<TopicPartition>();

        if (partitionInfos != null){
            for (PartitionInfo partitionInfo : partitionInfos){
                list.add(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()));

                consumer.assign(list);
            }

            while (true){
                ConsumerRecords<String, String> records = consumer.poll(100);
            }
        }
    }

    private Map<TopicPartition, OffsetAndMetadata> currentOffset = new HashMap<TopicPartition, OffsetAndMetadata>();

    KafkaConsumer<String, String> consumer = kafkaComsumerHelper.getKafkaConsumer();

    private class HandleRebalance implements ConsumerRebalanceListener{

        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            System.out.println("Lost partitions in rebalance, commiting current offset : " + currentOffset);

            consumer.commitSync(currentOffset);

            consumer.subscribe(Collections.singleton("test"), new HandleRebalance());
        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

        }
    }
}


