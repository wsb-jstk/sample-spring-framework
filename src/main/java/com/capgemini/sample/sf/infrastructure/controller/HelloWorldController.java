package com.capgemini.sample.sf.infrastructure.controller;

import lombok.Value;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @see <a href="http://localhost:8080/mvc/hello3?name=Maciej">Example</a>
     */
    @GetMapping("/hello3")
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello-with-exception")
    public String helloName() {
        throw new IllegalStateException("some error");
    }

    @ResponseBody
    @ExceptionHandler
    public CustomError customExceptionHandler(IllegalStateException exception) {
        return new CustomError(exception.getMessage());
    }

    @Value
    private static class CustomError {
        String text;
    }
}
