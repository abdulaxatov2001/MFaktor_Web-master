package com.example.clientservice.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;


@Configuration
@EnableJms
public class ActiveMqConfig {

    @Value("${activemq.broker.url}")
    private String brokerUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //navbat
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("clientServiceQueue");
    }

    //connection
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }

}