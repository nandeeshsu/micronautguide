package com.nandu.jitte.controller;

import com.nandu.jitte.client.MyApiService;
import com.nandu.jitte.model.Hello;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.Environment;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Controller("/hello")
@Slf4j
public class HelloController {

    @Value("${greeting.message}")
    private String message;

    //Note:- access the active environments programmatically
    @Inject
    Environment environment;

    @Inject
    MyApiService myApiService;

    @Get("text")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloText(){
        log.info("myApiService.getData:: {}", myApiService.getData());
        return "Welcome to micronaut";
    }

    @Get("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello helloJson(){
        //NOTE:- environment.getProperty() returns the Optional object
        log.info(" property via Environment bean {}" ,
                environment.getProperty("greeting.message", String.class).get());

        return Hello.builder().message(message).build();
    }

    @Get("json/env")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello helloEnvVarJson(){
        Optional<String> environmentProperty = environment.getProperty("greeting.environmentVariable", String.class);
        return Hello.builder().message(environmentProperty.orElse("Didn't find any variable set in the environment")).build();
    }
}
