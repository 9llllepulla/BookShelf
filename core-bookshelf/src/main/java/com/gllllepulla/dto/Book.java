package com.gllllepulla.dto;

public record Book(Long id,
                   String title,
                   String authorName,
                   int yearPublication,
                   String genreName,
                   String publisherName) {
}
