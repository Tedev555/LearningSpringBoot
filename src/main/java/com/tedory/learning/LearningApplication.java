package com.tedory.learning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LearningApplication implements ApplicationRunner, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello from Application Runner!");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from Command Line Runner!");
    }
}
