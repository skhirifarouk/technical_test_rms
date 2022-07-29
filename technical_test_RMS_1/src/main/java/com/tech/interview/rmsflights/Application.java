package com.tech.interview.rmsflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.tech.interview.rmsflights")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
