package com.app.controller;

import com.app.telegram.TelegramBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/telegram")
@RequiredArgsConstructor
@Slf4j
public class TelegramController {

   private final TelegramBot telegramBot;

    @PostMapping("/send")
    public void send(@RequestParam String message) {
       telegramBot.sendMessageToAllUsers(message);
    }

    @PostMapping("/send/img")
    public void sendImage(@RequestParam String url) {
        telegramBot.sendPhotoFromUrlToAllUsers(url);
    }

}
