package com.nandu.jitte.client;

import io.micronaut.context.annotation.Context;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Context
@Slf4j
public class MyApiService {
    private final FirstApiClient firstApiClient;
    private final MySecondApiClient mySecondApiClient;

    @Inject
    public MyApiService(FirstApiClient firstApiClient, MySecondApiClient mySecondApiClient) {
        this.firstApiClient = firstApiClient;
        this.mySecondApiClient = mySecondApiClient;
    }

    public String getData() {
        String apiKey = firstApiClient.getApiKey();
        log.info("apiKey :: {}" , apiKey);
        return mySecondApiClient.getData(apiKey);
    }
}
