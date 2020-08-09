package com.coffeebrew.contentproviderservice.controllers;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.services.ContentService;
import com.coffeebrew.contentproviderservice.services.FileStorageService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@SpringBootTest
class ContentControllerTest {
    EasyRandom random;

    @Mock
    FileStorageService fileStorageService;

    @Mock
    ContentService contentService;

    @InjectMocks
    ContentController contentController;


    @BeforeEach
    void setUp() {
        random = new EasyRandom();
    }

    @Test
    public void shouldStoreFile() {
        byte[] contentByte = null;
        MultipartFile file = new MockMultipartFile("filename.txt", "filename.txt", "wdwc", contentByte);
        Content content = random.nextObject(Content.class);

        when(fileStorageService.storeFile(file)).thenReturn("filename.txt");
        when(contentService.save(eq(new Content("filename.txt")))).thenReturn(content);

        ResponseEntity<Content> responseEntity = contentController.uploadFile(file);

        assertEquals(content, responseEntity.getBody());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}