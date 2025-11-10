package com.app.telegram;

import com.app.entity.User;
import com.app.service.UserService;
import java.io.File;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    private final UserService userService;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            log.info("Received message: {}", text);

            Message msg = update.getMessage();
            if (text.equals("/start")) {
                userService.createNewUser(msg);
            } else if (text.startsWith("/send ")) {
                sendMessageToAllUsers(text.replace("/send ", "").trim());
            }  else if (text.startsWith("/photo")) {
               sendPhotoToAllUsers();
            } else {
                showUi(msg.getChatId());
            }
        }
    }


    private void showUi(Long chatId) {
        SendMessage msg = new SendMessage(chatId.toString(),
            "Выберите действие:");
        msg.setReplyMarkup(mainKeyboard());
        executeMessage(msg);
    }


    private InlineKeyboardMarkup mainKeyboard() {
        InlineKeyboardButton btnSend = new InlineKeyboardButton("🚀 Отправить");
        btnSend.setCallbackData("BROADCAST_PRESET");

        InlineKeyboardButton btnCompose = new InlineKeyboardButton("✍️ Написать и отправить");
        btnCompose.setCallbackData("COMPOSE_BROADCAST");

        List<List<InlineKeyboardButton>> rows = List.of(
            List.of(btnSend, btnCompose)
        );
        InlineKeyboardMarkup kb = new InlineKeyboardMarkup();
        kb.setKeyboard(rows);
        return kb;
    }

    //@Scheduled(fixedDelay = 60000)
    private void scheduleMessage() {
        for (User user : userService.getUsers()) {
            SendMessage mes = new SendMessage();
            mes.setChatId(Long.parseLong(user.getChatId()));
            mes.setText(Instant.now().toString());
            executeMessage(mes);
        }
    }


    private void executeMessage(BotApiMethodMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void sendMessageToAllUsers(String message) {
        for (User user : userService.getUsers()) {
            SendMessage mes = new SendMessage();
            mes.setChatId(Long.parseLong(user.getChatId()));
            mes.setText(message);
            executeMessage(mes);
        }
    }

    @SneakyThrows
    public void sendPhotoToAllUsers() {
        for (User user : userService.getUsers()) {
           sendPhoto(Long.parseLong(user.getChatId()));
        }
    }

    @SneakyThrows
    public void sendPhotoFromUrlToAllUsers(String url) {
        for (User user : userService.getUsers()) {
            sendPhotoFromUrl(Long.parseLong(user.getChatId()), url);
        }
    }

    private void sendPhoto(Long chatId) throws TelegramApiException {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId.toString());
        InputFile inputFile = new InputFile(new File("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/mvnProjects/TlgBot/src/main/resources/image.png"));
        photo.setPhoto(inputFile);
        photo.setCaption("test photo");
        execute(photo);
    }
    private void sendPhotoFromUrl(Long chatId, String url) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId.toString());

        InputFile file = new InputFile();
        file.setMedia(url);
        sendPhoto.setPhoto(file);
        sendPhoto.setCaption("Фото по URL");

        execute(sendPhoto);
    }

}
