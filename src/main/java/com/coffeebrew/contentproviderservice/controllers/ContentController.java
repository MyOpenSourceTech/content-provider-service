package com.coffeebrew.contentproviderservice.controllers;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.services.ContentService;
import com.coffeebrew.contentproviderservice.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<Content> getFileMeta(@PathVariable String id) {
        Optional<Content> content = contentService.getById(id);
        if (content.isEmpty()) {
            return new ResponseEntity<Content>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Content>(content.get(), HttpStatus.OK);
        }
    }
}