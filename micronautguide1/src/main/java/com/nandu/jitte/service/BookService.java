package com.nandu.jitte.service;

import com.nandu.jitte.db.entities.Book;
import com.nandu.jitte.db.repo.BookRepository;
import com.nandu.jitte.mapper.BookMapper;
import com.nandu.jitte.model.BookDto;
import com.nandu.jitte.model.BookUpdateCommand;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.save(bookMapper.toEntity(bookDto));
        return bookMapper.toDto(book);
    }

    public BookDto saveWithException(BookDto bookDto) {
        Book book = bookRepository.saveWithException(bookMapper.toEntity(bookDto));
        return bookMapper.toDto(book);
    }

    public BookDto findBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.isPresent() ? bookMapper.toDto(book.get()) : BookDto.builder().build();
    }

    public List<BookDto> findAllBooks(Pageable pageable){
        List<Book> bookList = bookRepository.findAll(pageable).getContent();

        return bookList.stream().map(
                book -> BookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public void updateBook(BookUpdateCommand bookUpdateCommand) {
        bookRepository.findByName(bookUpdateCommand.getName()).ifPresent(
                book -> {
                    book.setName(bookUpdateCommand.getName());
                    bookRepository.update(book);
                }
        );

    }
}
