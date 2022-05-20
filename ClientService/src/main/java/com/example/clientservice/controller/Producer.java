package com.example.clientservice.controller;

import com.example.clientservice.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;

@RestController
@RequestMapping("/produce")
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private RestTemplate restTemplate;
    private final Queue queue;

    @PostMapping("/message")
    public User sendMessage(@RequestBody User user) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(user);
            jmsTemplate.convertAndSend(queue, string);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //backend urlni chaqirish kerak
//        restTemplate.getForObject();
        return user;
    }
}
