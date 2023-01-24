package com.gllllepulla.service.search;

import com.gllllepulla.dto.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SearchBookService {

    List<Book> getAllBooks();

    Optional<Book> findBookById(Long bookId);

    List<Book> findBooksByTitles(Set<String> titles);

    List<Book> findBooksByAuthorsNames(Set<String> names);
}
