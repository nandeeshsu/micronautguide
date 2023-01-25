package com.nandu.jitte.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@Getter
@Setter
@AllArgsConstructor
public class BookUpdateCommand {
    @NotNull
    private final Long id;

    @NotBlank
    private final String name;
}
