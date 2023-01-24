package com.nandu.jitte.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nandu.jitte.model.Hello;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/demo")
    HttpClient httpClient;

    @Test
    public void testHelloText(){
        HttpRequest<String> httpRequest = HttpRequest.GET("/hello/text");
        String body = httpClient.toBlocking().retrieve(httpRequest);

        assertNotNull(body);
        assertEquals("Welcome to micronaut", body);
    }

    @Test
    public void testHelloJson(){
        HttpRequest<String> httpRequest = HttpRequest.GET("/hello/json");
        String body = httpClient.toBlocking().retrieve(httpRequest);

        assertNotNull(body);
        assertEquals("{\"message\":\"Hello from micronaut guide default env\"}", body);
    }
}
