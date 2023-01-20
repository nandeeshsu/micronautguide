package com.nandu.jitte.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void testHello(){
        HttpRequest<String> httpRequest = HttpRequest.GET("/hello");
        String body = httpClient.toBlocking().retrieve(httpRequest);

        assertNotNull(body);
        assertEquals("Welcome to micronaut", body);
    }
}
