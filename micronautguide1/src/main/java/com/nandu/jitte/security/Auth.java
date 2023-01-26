package com.nandu.jitte.security;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import io.micronaut.core.annotation.Internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Around
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Type(AuthInterceptor.class)
//@Internal
public @interface Auth {
}
