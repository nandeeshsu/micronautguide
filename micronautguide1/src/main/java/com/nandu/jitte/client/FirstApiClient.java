package com.nandu.jitte.client;

import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:8080/demo")
public interface FirstApiClient {

    @Get("/api-key")
    @Cacheable(value = "api-key")
    String getApiKey();

}
