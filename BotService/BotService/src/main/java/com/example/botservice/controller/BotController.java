package com.example.botservice.controller;

import com.example.botservice.bot.MFaktorBot;
import com.example.botservice.bot.TelegramServiceImpl;
import com.example.botservice.entity.Event;
import com.example.botservice.entity.User;
import com.example.botservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class BotController {

    private final TelegramServiceImpl telegramService;
    private final MFaktorBot mFaktorBot;
    private final UserRepository userRepository;

    @PostMapping("/sendMessageUsers")
    public void setAllMessage(@RequestBody Event event) {

        List<User> userList = userRepository.findAllByChatIdIsNotNull();
//        List<String> listChatId = new ArrayList<>();

        for (User user : userList) {
            String chatId = user.getChatId();
            try {
                mFaktorBot.execute(telegramService.sendXabar(Long.valueOf(chatId)));
                mFaktorBot.execute(telegramService.sendNotification(Long.valueOf(chatId),event));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        //ishlamadi
//        for (User user : userList) {
//            listChatId.add(user.getChatId());
//        }
//        List<SendMessage> sendMessageList = telegramService.sendMessageUsers(event, listChatId);
//        for (SendMessage sendMessage : sendMessageList) {
//            try {
//                mFaktorBot.execute(sendMessage);
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }
//        }


    }

}
