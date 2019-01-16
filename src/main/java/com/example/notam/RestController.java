package com.example.notam;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }
}
