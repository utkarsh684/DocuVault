package com.example.DocuVault.scheduler;

import com.example.DocuVault.model.Document;
import com.example.DocuVault.service.DocumentService;
import com.example.DocuVault.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpiryRemainderScheduler {

    @Autowired
    private DocumentService documentService;
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 0 9 * * *")
    public void sendExpiryRemainders(){
        System.out.println("Running scheduled reminder...");
        List<Document> docs=documentService.getExpiringSoonDocs();
        for(Document doc:docs){
            mailService.sendReminder(doc.getUserEmail(),doc.getName(),doc.getExpiryDate());
        }
    }

}
