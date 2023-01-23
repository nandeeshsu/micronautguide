package com.nandu.jitte;

import io.micronaut.http.annotation.*;

@Controller("/demoHelloApiGradle")
public class DemoHelloApiGradleController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}