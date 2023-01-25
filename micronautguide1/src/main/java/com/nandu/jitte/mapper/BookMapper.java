package com.nandu.jitte.mapper;

import com.nandu.jitte.db.entities.Book;
import com.nandu.jitte.model.BookDto;
import com.nandu.jitte.model.BookUpdateCommand;
import jakarta.inject.Singleton;

@Singleton
public class BookMapper {

    public Book toEntity(BookDto bookDto) {
        return Book.builder().name(bookDto.getName()).build();
    }

    public BookDto toDto(Book book) {
        return BookDto.builder().name(book.getName()).id(book.getId()).build();
    }

    public Book toEntity(BookUpdateCommand bookUpdateCommand) {
        return Book.builder().name(bookUpdateCommand.getName()).id(bookUpdateCommand.getId()).build();
    }
}
