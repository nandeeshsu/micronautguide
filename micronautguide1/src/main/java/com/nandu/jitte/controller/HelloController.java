package com.nandu.jitte.controller;

import com.nandu.jitte.model.Hello;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloController {

    @Get("text")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloText(){
        return "Welcome to micronaut";
    }

    @Get("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello helloJson(){
        /*Hello hello = new Hello();
        hello.setMessage("Welcome to micronaut");
        return hello;*/
        return Hello.builder().message("Welcome to micronaut").build();
    }
}
