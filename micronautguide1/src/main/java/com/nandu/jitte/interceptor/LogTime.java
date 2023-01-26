package com.nandu.jitte.interceptor;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Around
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Type(LogTimeInterceptor.class)
public @interface LogTime {
}
