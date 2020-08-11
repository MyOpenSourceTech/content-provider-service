package com.coffeebrew.contentproviderservice.controllers;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.services.ContentService;
import com.coffeebrew.contentproviderservice.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/content")
public class ContentController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ContentService contentService;

    @PostMapping("/upload")
    public ResponseEntity<Content> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        Content content = contentService.save(new Content(fileName));

        return new ResponseEntity<Content>(content, HttpStatus.CREATED);
    }
}