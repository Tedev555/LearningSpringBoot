package com.tedory.learning;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningApplication {
    private static final Logger logger = LoggerFactory.getLogger(LearningApplication.class.getName());

    public static void main(String[] args) {
        logger.info("This is a info message");
        logger.warn("This is a info message");
        logger.error("This is a error message");
        SpringApplication.run(LearningApplication.class, args);
    }

}
