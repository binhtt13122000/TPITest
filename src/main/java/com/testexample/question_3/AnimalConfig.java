package com.testexample.question_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    @Bean("giraffe")
    public IAnimal giraffe() {
        return () -> System.out.println("Giraffe eat grass.");
    }

    @Bean("panda")
    public IAnimal panda() {
        return () -> System.out.println("Panda eat bamboo.");
    }
}
