package com.gllllepulla.mapper;

import com.gllllepulla.api.info.AuthorInfo;
import com.gllllepulla.dto.Author;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

    AuthorInfo toAuthorInfo(Author author);
}
