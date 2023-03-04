package com.springbootjpa.springbootjpa;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class AbstractTest {
    @Container
    private static PostgreSQLContainer container  = new PostgreSQLContainer<>("postgres");

    @DynamicPropertySource
    public static void overrideProp(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",container::getJdbcUrl);
        registry.add("spring.datasource.username",container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);

    }

    @BeforeAll
    public static void setUp(){
        container.start();
    }
}
