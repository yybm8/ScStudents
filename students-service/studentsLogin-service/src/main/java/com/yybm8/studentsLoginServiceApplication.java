package com.yybm8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class studentsLoginServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(studentsLoginServiceApplication.class, args);
    }
}