package com.example.DocuVault.service;

import com.example.DocuVault.model.Document;
import com.example.DocuVault.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public void deleteDoc(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public List<Document> getExpiringSoonDocs(){
        LocalDate now= LocalDate.now();
        LocalDate in7Days=now.plusDays(7);
        return documentRepository.findByExpiryDateBetween(now,in7Days);
    }
}
