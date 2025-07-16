package com.example.DocuVault.controller;

import com.example.DocuVault.scheduler.ExpiryRemainderScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ExpiryRemainderScheduler scheduler;

    @GetMapping("/send-reminders")
    public ResponseEntity<String> sendTestReminders() {
        scheduler.sendExpiryRemainders();
        return ResponseEntity.ok("Reminder emails sent (if any documents expire in next 7 days)");
    }

}
