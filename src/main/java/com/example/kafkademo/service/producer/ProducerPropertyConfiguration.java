package com.example.kafkademo.service.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ProducerPropertyConfiguration {

    @Bean
    public Properties producerProperties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.31.198:9092");
        props.put("acks", "all");
        props.put("client.id", "1");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

}
