package com.coffeebrew.contentproviderservice.repositories;

import com.coffeebrew.contentproviderservice.models.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepository extends CrudRepository<Content, String> {
}
