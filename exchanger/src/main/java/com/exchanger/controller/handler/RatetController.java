package com.exchanger.controller.handler;

import com.exchanger.service.RateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class RatetController {

    private final RateService rateService;

    @GetMapping("/rate")
    public void getRate() {
        rateService.getRates();
    }
}
