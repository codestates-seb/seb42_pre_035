package com.team035.pre_project35;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PreProject35Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PreProject35Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { // (2)
        return builder.sources(PreProject35Application.class);
    }
}
