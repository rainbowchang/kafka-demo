package com.example.kafkademo;

import com.example.kafkademo.service.consumer.Consumer;
import com.example.kafkademo.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Runner {

    @Autowired
    private ApplicationArguments applicationArguments;

    @Autowired
    private Consumer consumer;

    @Autowired
    private Producer producer;

    @PostConstruct
    public void run() {
        List<String> args = applicationArguments.getNonOptionArgs();
        if (args == null || args.size() == 0) {
            return;
        }
        String arg = args.get(0);
        if (arg == null || arg.trim().isEmpty()) {
            return;
        }
        switch (arg) {
            case "produce":
                producer.run();
                break;
            default:
                consumer.run(arg);
        }
    }
}
