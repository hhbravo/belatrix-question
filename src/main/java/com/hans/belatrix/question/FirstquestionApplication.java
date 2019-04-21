package com.hans.belatrix.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirstquestionApplication extends SpringBootServletInitializer {
    private static Logger loger = LogManager.getLogger(FirstquestionApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FirstquestionApplication.class);
    }

    public static void main(String[] args) {
        loger.info("Starting Spring Boot List Cards Wrapper application..");
        SpringApplication.run(FirstquestionApplication.class, args);
    }
}
