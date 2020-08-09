package com.coffeebrew.contentproviderservice.services;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.repositories.ContentRepository;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
    @Autowired
    ContentRepository contentRepository;

    public Content save(Content content) {
        return contentRepository.save(content);
    }
}
