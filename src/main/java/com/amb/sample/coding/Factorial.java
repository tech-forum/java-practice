package com.amb.sample.coding;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(getFactorial(10));
    }

    private static int getFactorial(int number) {
        AtomicInteger fact = new AtomicInteger(1);
        IntStream.range(1, number).forEach(value -> {
            fact.set(value * fact.get());
        });
        return fact.get();
    }
}
