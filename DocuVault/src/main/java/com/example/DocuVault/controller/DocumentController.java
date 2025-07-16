package com.example.DocuVault.controller;

import com.example.DocuVault.model.Document;
import com.example.DocuVault.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> addDoc(@RequestBody Document document){
        return ResponseEntity.ok(documentService.save(document));
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocs(){
        return ResponseEntity.ok(documentService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoc(@PathVariable Long id){
                documentService.deleteDoc(id);
                return ResponseEntity.noContent().build();
    }

}
