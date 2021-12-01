package com.capgemini.sample.sf.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = {"/hello", "/*.abc"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello world!";
    }
}
