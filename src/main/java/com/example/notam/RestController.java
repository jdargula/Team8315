package com.example.notam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    String helloName(@RequestBody String name) {
        return "hello " + name;
    }

    @GetMapping("/atlanta")
    String atlanta() { return "atlanta"; }
}
