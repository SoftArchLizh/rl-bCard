package com.volvo.invoice.controller;


import com.volvo.invoice.service.impl.SBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Author: 李中华
 * Date: 2024/10/19 21:05
 **/
@Controller
@RequiredArgsConstructor
public class SBotController {

    private final SBotService sBotService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody String question) {
//        try {
//            return ResponseEntity.ok(sBotService.askQuestion(question));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Sorry, I can't process your question right now.");
//        }
        return ResponseEntity.badRequest().body("Sorry, I can't process your question right now.");
    }
}
