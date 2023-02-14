package com.nandu.jitte.client;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.HttpClientConfiguration;
import io.micronaut.runtime.server.EmbeddedServer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.net.MalformedURLException;
import java.net.URL;

//@Factory
@Singleton
public class MyApiClientFactory {

    private final HttpClientConfiguration httpClientConfiguration;

    @Inject
    public MyApiClientFactory(HttpClientConfiguration httpClientConfiguration) {
        this.httpClientConfiguration = httpClientConfiguration;
    }

    public FirstApiClient createFirstApiClient() {
        URL baseUrl = null;
        try {
            baseUrl = new URL("http://localhost:8080");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return (FirstApiClient) HttpClient.create(baseUrl, httpClientConfiguration);
    }
}
