package com.gllllepulla.api.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookInfo {
    @NotNull
    @Size(min = 2, max = 100)
    private String title;
    @Null
    private Integer yearPublication;
    @Null
    private String genreName;
    @Null
    private String publisherName;
    @NotNull
    @Size(min = 2, max = 100)
    private String authorName;
}
