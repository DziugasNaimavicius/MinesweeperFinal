package org.example;

import java.util.Random;

public class RandomGenerator {
    private static Random instance;

    private RandomGenerator() {}

    public static Random getInstance() {
        if (instance == null) {
            instance = new Random();
        }
        return instance;
    }
}
