package com.gymrats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestGymRatsLogbookBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(GymRatsLogbookBackendApplication::main).with(TestGymRatsLogbookBackendApplication.class).run(args);
    }

}
