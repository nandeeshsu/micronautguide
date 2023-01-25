package com.nandu.jitte.db.repo;

import com.nandu.jitte.db.entities.Book;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface BookRepository extends PageableRepository<Book, Long> {

    @Transactional
    default Book saveWithException(@NonNull @NotBlank Book book) {
        save(book);
        throw new DataAccessException("test exception");
    }

    Optional<Book> findByName(String name);
}
