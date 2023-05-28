package com.aqualen.springpostgresqltestconteiners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
class TestApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(SpringPostgresqlTestconteinersApplication::main)
                .with(TestApplication.class)
                .run(args);
    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>("postgres");
    }

}
