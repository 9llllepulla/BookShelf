package com.gllllepulla.api.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorInfo {
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @Nullable
    private Instant born;
}
