package com.gllllepulla.mapper;

import com.gllllepulla.api.info.BookInfo;
import com.gllllepulla.dto.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookInfo toBookInfo(Book book);
}
