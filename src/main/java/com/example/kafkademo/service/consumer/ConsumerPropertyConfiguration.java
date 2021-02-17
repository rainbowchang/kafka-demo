package com.example.kafkademo.service.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

public class ConsumerPropertyConfiguration {

    public static Properties consumerProperties(String groupid){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.31.198:9092");
        props.put("group.id", groupid);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
