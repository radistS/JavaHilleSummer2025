package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/ping")
    public String ping() {
        System.out.println(String.format(CALL_ENDPOINT, "ping") + System.currentTimeMillis());
        return "work - OK";
    }

    @GetMapping("/{name}")
    public String ping(@PathVariable String name) {
        return "work - OK " + name;
    }
}
