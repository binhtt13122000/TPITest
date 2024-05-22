package com.testexample.question_4;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final QueryDAO queryDAO;
    private final Environment env;

    @Bean
    public Calculation calculation() {
        return new Calculation(queryDAO, env);
    }
}
