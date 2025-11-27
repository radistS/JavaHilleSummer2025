package com.exchanger.service;

import com.exchanger.entity.RateEntity;
import com.exchanger.entity.enums.CurrencyEnum;
import com.exchanger.exceptions.ExternalHttpCallException;
import com.exchanger.repository.RateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateService {

    private final RateRepository rateRepository;
    private final ObjectMapper objectMapper;

    @Value("${bank.rate.url}")
    private String bankUrl;

    @SneakyThrows
    @Scheduled(cron = "${schedule.cron.time.table}")
        /*
    +-------------------- second (0 - 59)
    |  +----------------- minute (0 - 59)
    |  |  +-------------- hour (0 - 23)
    |  |  |  +----------- day of month (1 - 31)
    |  |  |  |  +-------- month (1 - 12)
    |  |  |  |  |  +----- day of week (0 - 6) (Sunday=0 or 7)
    |  |  |  |  |  |  +-- year [optional]
    |  |  |  |  |  |  |
    *  *  *  *  *  *  * command to be executed
    */
    public void getRates(){
        log.info("getRates");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(bankUrl, String.class);
        log.error(response.getBody());

        if (response.getStatusCode().isError()){
            throw new ExternalHttpCallException("Bank Rate Error");
        }

        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        jsonNode.forEach(node -> {
            if (node.get("ccy").asText().equals("USD") || node.get("ccy").asText().equals("EUR")){
                RateEntity rate = new RateEntity()
                    .setBuy(node.get("buy").asText())
                    .setSale(node.get("sale").asText())
                    .setReceive(new Timestamp(System.currentTimeMillis()))
                    .setCurrency(CurrencyEnum.valueOf(node.get("ccy").asText()));
                rateRepository.save(rate);
            }
        });

    }
}
