package com.nandu.jitte.filter;

import io.micronaut.http.HttpParameters;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpRequestWrapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Filter("/**")
@Slf4j
public class RequestResponseLogger implements HttpFilter {

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {

        HttpRequest<?> request1 = new HttpRequestWrapper<>(request);

        log.info("REQUEST PARAMETER:: {}" , request1.getParameters().asMap());
        //In Micronaut 2.5 onwards the body will not be read until after filters are executed.
        //This may lead to cases where the body was available in a filter and is no longer available.
        log.info("REQUEST BODY:: {}", request1.getBody().isPresent() ? request1.getBody().get() : "NO BODY");
        log.info("REQUEST HEADERS:: {}", request1.getHeaders().asMap());

        return chain.proceed(request);
    }
}
