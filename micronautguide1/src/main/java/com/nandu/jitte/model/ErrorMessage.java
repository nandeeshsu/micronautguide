package com.nandu.jitte.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Serdeable
@Introspected
@Getter
@Setter
@ToString
@Builder
public class ErrorMessage {
    private String message;
    private Boolean status;
}
