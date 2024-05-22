package com.testexample.question_3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Zoo {
    private final IAnimal tiger;
    private final IAnimal zebra;

    public Zoo(@Qualifier("panda") IAnimal panda, @Qualifier("giraffe") IAnimal giraffe) {
        tiger = giraffe;
        zebra = panda;
        feedAnimals();
    }

    public void feedAnimals() { // Separated method for clarity
        tiger.eat();
        zebra.eat();
    }
}
