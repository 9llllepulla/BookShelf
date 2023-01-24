package com.gllllepulla.api.controller;

import com.gllllepulla.api.info.AuthorInfo;
import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.service.search.SearchAuthorService;
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
public class SearchAuthorController {

    private final SearchAuthorService searchAuthorService;
    private final AuthorMapper authorMapper;

    @Operation(summary = "Список всех авторов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorInfo>> getAllAuthors() {
        List<AuthorInfo> allAuthors = searchAuthorService.getAllAuthors().stream()
                .map(authorMapper::toAuthorInfo).toList();
        return ResponseEntity.ok(allAuthors);
    }

    @Operation (summary = "Запрос автора по id")
    @GetMapping("/authors/{authorId}")
    public ResponseEntity<AuthorInfo> getAuthorById(@PathVariable Long authorId) {
        return searchAuthorService.findAuthorById(authorId)
                .map(authorMapper::toAuthorInfo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (summary = "Запрос автора (-ов) по имени (-ам)")
    @GetMapping(value = "/authors/name")
    public ResponseEntity<List<AuthorInfo>> getAuthorsByName(@RequestParam Set<String> names) {
        List<AuthorInfo> authors = searchAuthorService.findAuthorsByNames(names).stream()
                .map(authorMapper::toAuthorInfo).toList();
        return ResponseEntity.ok(authors);
    }

    @Operation (summary = "Запрос автора (-ов) по названию книг (-и)")
    @GetMapping(value = "/authors/books")
    public ResponseEntity<List<AuthorInfo>> getAuthorsByBooksTitles(@RequestParam Set<String> titles) {
        List<AuthorInfo> authors = searchAuthorService.findAuthorsByBookTitles(titles).stream()
                .map(authorMapper::toAuthorInfo).toList();
        return ResponseEntity.ok(authors);
    }
}
