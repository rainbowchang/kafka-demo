package com.example.kafkademo.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Service
public class Consumer {
//https://blog.csdn.net/twypx/article/details/81274582   需要看一下
//https://www.cnblogs.com/wolf-bin/p/9085370.html

    public void run(String groupid) {
        Properties properties = ConsumerPropertyConfiguration.consumerProperties(groupid);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("kafka_test"));
        while (true) {
            System.out.println("************************* poll");
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
            System.out.println("*************************Length = " + records.count());
            if (records.count() > 0) {
                try {
                    consume(records);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void consume(ConsumerRecords<String, String> records) throws IOException {
        for (ConsumerRecord<String, String> record : records) {
            System.out.println("record.value" + record.value());
        }
    }

}
