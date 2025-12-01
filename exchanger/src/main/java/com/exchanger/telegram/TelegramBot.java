package com.exchanger.telegram;

import com.exchanger.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final UserService userService;

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            log.info(update.getMessage().getChatId().toString());
            log.info(update.getMessage().getFrom().getUserName());

            SendMessage message = new SendMessage();
            message.setChatId(chat_id);
            if (message_text.equals("/start")) {
                message.setText("Please send your login phone number in international format +XXX...");
            } else {
                System.out.println(message_text);
                message.setText(userService.activateUser(message_text, chat_id));
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        executeMessage(message);
    }

    private void executeMessage(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

}
