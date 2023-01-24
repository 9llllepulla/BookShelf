package com.gllllepulla.api.controller;

import com.gllllepulla.api.info.BookInfo;
import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.service.search.SearchBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchBookController {

    private final SearchBookService searchBookService;
    private final BookMapper bookMapper;

    @Operation(summary = "Список всех книг")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/books")
    public ResponseEntity<List<BookInfo>> getAllBooks() {
        List<BookInfo> allBooks = searchBookService.getAllBooks().stream()
                .map(bookMapper::toBookInfo).toList();
        return ResponseEntity.ok(allBooks);
    }

    @Operation (summary = "Запрос книги по id")
    @GetMapping("/books/{id}")
    public ResponseEntity<BookInfo> getBookById(@PathVariable Long id) {
        return searchBookService.findBookById(id)
                .map(bookMapper::toBookInfo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (summary = "Запрос книг (-и) по наименованию (-ям)")
    @GetMapping(value = "/books/title")
    public ResponseEntity<List<BookInfo>> getBooksByTitle(@RequestParam Set<String> titles) {
        List<BookInfo> books = searchBookService.findBooksByTitles(titles).stream()
                .map(bookMapper::toBookInfo).toList();
        return ResponseEntity.ok(books);
    }

    @Operation (summary = "Запрос книг (-и) по имени автора (-ов)")
    @GetMapping(value = "/books/author")
    public ResponseEntity<List<BookInfo>> getBooksByAuthorsNames(@RequestParam Set<String> names) {
        List<BookInfo> books = searchBookService.findBooksByAuthorsNames(names).stream()
                .map(bookMapper::toBookInfo).toList();
        return ResponseEntity.ok(books);
    }

}
