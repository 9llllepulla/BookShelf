package com.gllllepulla.service.search;

import com.gllllepulla.dto.Author;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SearchAuthorService {

    List<Author> getAllAuthors();

    Optional<Author> findAuthorById(Long authorId);

    List<Author> findAuthorsByNames(Set<String> names);

    List<Author> findAuthorsByBookTitles(Set<String> titles);

}
