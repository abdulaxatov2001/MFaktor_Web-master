package com.example.botservice.bot;


import com.example.botservice.entity.Event;
import com.example.botservice.entity.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface TelegramService {

    SendMessage sendXabar(Long chatId);

    SendPhoto sendNotification(Long chatId, Event event);

    SendMessage menu(Update update);

    SendMessage order(Update update);

    SendMessage selectCategory(Update update);

    SendMessage selectEvent(Update update);

    SendMessage myOrders(Update update);

    SendMessage settings(Update update);

    SendMessage aboutUs(Update update);

    SendMessage comment(Update update);

    SendMessage sendMessageWithEvent(Update update);

    SendMessage connection(Update update);

    SendMessage shareContact(Update update);


    SendMessage enterFullName(Update update);

    SendMessage enterCompanyName(Update update);

    SendMessage enterPosition(Update update);

    SendMessage enterRegister(Update update);

    List<SendMessage> sendMessageUsers(Event event, List<String> listChatId);
}
