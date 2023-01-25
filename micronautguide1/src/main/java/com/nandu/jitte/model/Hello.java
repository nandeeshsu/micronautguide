package com.nandu.jitte.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

@Serdeable // after database integration this Hello stopped working, hence had add this to tell it's serializable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hello {
    private String message;
}
