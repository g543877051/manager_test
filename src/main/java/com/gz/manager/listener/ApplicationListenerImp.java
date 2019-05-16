package com.gz.manager.listener;

import com.gz.manager.kafka.KafkaComsumerHelper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年02月19日<br>
 */
@Component
public class ApplicationListenerImp implements ApplicationListener<ApplicationEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListenerImp.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
      /*  if (applicationEvent instanceof ApplicationPreparedEvent) {
            LOGGER.info("application is prepared");

            KafkaComsumerHelper comsumerHelper = new KafkaComsumerHelper();

            KafkaConsumer<String, String> consumer = comsumerHelper.getKafkaConsumer();

            //订阅名字为test的topic
            consumer.subscribe(Collections.singletonList("test"));

            Map<String, Integer> custCountryMap = new HashMap<String, Integer>();

            int updatedCount = 1;

            //消费者开机时就启动，一直轮询消费

            try {
                //消费者是一个长期运行的程序，通过持续轮询向Kafka请求数据。在其他线程中调用consumer.wakeup()可以退出循环
                //在100ms内等待Kafka的broker返回数据.超时参数指定poll在多久之后可以返回，不管有没有可用的数据都要返回
                Duration duration = Duration.ZERO;

                ConsumerRecords<String, String> records = consumer.poll(100);
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

            LOGGER.error("comsumer is stop");

        }*/
    }
}
