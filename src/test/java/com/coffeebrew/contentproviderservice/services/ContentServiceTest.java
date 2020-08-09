package com.coffeebrew.contentproviderservice.services;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.repositories.ContentRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContentServiceTest {

    @Mock
    ContentRepository contentRepository;

    @InjectMocks
    ContentService target;

    EasyRandom random;

    @BeforeEach
    void setUp() {
        random = new EasyRandom();
    }

    @Test
    public void shouldSaveContentMetaData() {
        Content content = random.nextObject(Content.class);
        when(contentRepository.save(content)).thenReturn(content);

        Content savedContent = target.save(content);

        assertEquals(content, savedContent);
    }
}