package com.example.DocuVault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReminder(String to, String docName, LocalDate expiry){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("📌 Document Expiry Reminder – DocuVault");
        message.setText("Reminder: Your document \"" + docName + "\" will expire on " + expiry + ". Please take action.");
        mailSender.send(message);
    }
}
