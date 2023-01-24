package com.nandu.jitte.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(environments = "dev")
public class HelloControllerEnvProfileTest {

    @Inject
    @Client("/demo")
    HttpClient httpClient;

    @Test
    public void testHelloJson(){
        HttpRequest<String> httpRequest = HttpRequest.GET("/hello/json");
        String body = httpClient.toBlocking().retrieve(httpRequest);

        assertNotNull(body);
        assertEquals("{\"message\":\"Hello from micronaut guide dev env\"}", body);
    }
}
