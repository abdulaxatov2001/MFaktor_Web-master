package com.example.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class KafkaRestController {

    private final MessageProducer producer;
    private final MessageRepository messageRepo;
    private final RestTemplate restTemplate;

    //Send message to kafka
    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String message) {
        producer.sendMessage(message);
        return "" + "'+message +'" + " sent successfully!";
    }

    //Read all messages
    @GetMapping("/getAll")
    public String getAllMessages() {
        return messageRepo.getAllMessages();
    }

    @GetMapping("/admin")
    public String getAdminService() {
        String object = restTemplate.getForObject("http://localhost:8080/api/admin/speaker/test", String.class);
        return object;
    }
}
