package com.example.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    private MessageRepository messageRepo;

    @KafkaListener(topics = "TOPIC", groupId = "test-consumer-group")
    public void consume(String message) {
        System.out.println("Qabul qildim");
        log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message + "Qabul qilindi");
        messageRepo.addMessage(message);
    }

}
