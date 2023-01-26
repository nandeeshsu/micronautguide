package com.nandu.jitte.controller;

import com.nandu.jitte.db.repo.BookRepository;
import com.nandu.jitte.exception.OutOfStockException;
import com.nandu.jitte.interceptor.LogTime;
import com.nandu.jitte.model.BookDto;
import com.nandu.jitte.model.BookUpdateCommand;
import com.nandu.jitte.security.Auth;
import com.nandu.jitte.service.BookService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;

@ExecuteOn(TaskExecutors.IO) //any blocking I/O operations (such as fetching the data from the database) are
// offloaded to a separate thread pool that does not block the Event loop.
@Controller("/books")
@Slf4j
//@Introspected
public class BookController {
    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService){
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{isbn}")
    Integer stock(String isbn) {
        throw new OutOfStockException();
    }

    @Get("/list")
    public List<BookDto> list(@Valid Pageable pageable) {
        return bookService.findAllBooks(pageable);
    }

    @Get("/{id}")
    public BookDto show(Long id) {
        return bookService.findBookById(id);
    }

    @Auth
    @Post
    @LogTime
    public HttpResponse<BookDto> save(@Body @NotBlank BookDto bookDto, @Header("Authorization") String authorizationHeader) {
        log.info("save request:: {}", bookDto.toString());
        BookDto bookDto1 = bookService.createBook(bookDto);

        return HttpResponse
                .created(bookDto1)
                .headers(headers -> headers.location(buildLocation(bookDto1.getId())));
    }

    @Post("/ex")
    public HttpResponse<BookDto> saveExceptions(@Body @NotBlank BookDto bookDto) {
        //try {
            BookDto bookDto1 = bookService.saveWithException(bookDto);
            return HttpResponse
                    .created(bookDto1)
                    .headers(headers -> headers.location(buildLocation(bookDto1.getId())));
        //} catch(DataAccessException e) {
            //return HttpResponse.noContent();
        //}
    }

    @Put
    public HttpResponse<?> update(@Body @Valid BookUpdateCommand command) {
        bookService.updateBook(command);

        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, buildLocation(command.getId()).getPath());
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    /*private URI location(Book book) {
        return location(book.getId());
    }*/

    protected URI buildLocation(Long id) {
        return URI.create("/books/" + id);
    }
}
