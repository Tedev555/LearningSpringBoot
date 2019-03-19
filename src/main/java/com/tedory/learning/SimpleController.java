package com.tedory.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    //Create simple Rest Endpoint with Request Mapping (Get/Post)
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
