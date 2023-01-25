package com.nandu.jitte.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Serdeable
@Slf4j
@Getter
@Setter
@Builder
public class BookDto {

    @Nullable
    private Long id;

    private String name;
}
