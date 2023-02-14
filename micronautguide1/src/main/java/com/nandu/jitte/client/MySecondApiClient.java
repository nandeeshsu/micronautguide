package com.nandu.jitte.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:8080/demo")
public interface MySecondApiClient {

    @Get("/data")
    String getData(@QueryValue("api_key") String apiKey);
}
