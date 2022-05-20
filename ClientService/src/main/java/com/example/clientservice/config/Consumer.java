package com.example.clientservice.config;

import io.netty.handler.logging.LogLevel;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Consumer {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "clientServiceQueue")
    public void consumeMessage(String message) {
        System.out.println("Qanisan Active MQ ishladimi?");
        logger.log(Level.INFO, "Message keldi Active MQ kutib oldi" + message);
    }
}
