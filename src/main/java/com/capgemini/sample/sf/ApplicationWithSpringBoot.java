package com.capgemini.sample.sf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class ApplicationWithSpringBoot extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplication().run(ApplicationWithSpringBoot.class);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ApplicationWithSpringBoot.class);
    }

}
