package com.coffeebrew.contentproviderservice.services;

import com.coffeebrew.contentproviderservice.models.Content;
import com.coffeebrew.contentproviderservice.repositories.ContentRepository;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    ContentRepository contentRepository;

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public Optional<Content> getById(String id) {
        return contentRepository.findById(id);
    }
}
