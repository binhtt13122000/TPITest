package com.testexample.question_4;

import org.springframework.core.env.Environment;

public class Calculation {
    private static volatile Calculation uniqueInstance;
    private Environment env;
    private QueryDAO dao;

    public Calculation(QueryDAO dao, Environment env) {
        this.env = env;
        this.dao = dao;
    }

    public static Calculation getInstance(QueryDAO dao, Environment env) {
        if (uniqueInstance == null) {
            synchronized (Calculation.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new Calculation(dao, env);
                }
            }
        }
        return uniqueInstance;
    }
}
