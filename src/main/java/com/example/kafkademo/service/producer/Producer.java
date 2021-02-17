package com.example.kafkademo.service.producer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Properties;

@Service
public class Producer {

    @Autowired
    public Properties producerProperties;

    public void run() {

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);
        while(true) {
            System.out.println("Producer ......");
            ProducerRecord<String, String> record = new ProducerRecord<>("kafka_test",
                    "Kafka_Products", LocalDateTime.now().toString());
            producer.send(record);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
