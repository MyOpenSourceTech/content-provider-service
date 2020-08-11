package com.coffeebrew.contentproviderservice.repositories;

import com.coffeebrew.contentproviderservice.models.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<Content, String> {
}
