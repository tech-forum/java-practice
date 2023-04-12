package com.amb.sample.coding;

import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 15 prime? " + isPrime(15));
        System.out.println("Is 47 prime? " + isPrime(47));
        System.out.println("Is 53 prime? " + isPrime(53));
        System.out.println("Is 110 prime? " + isPrime(110));
        System.out.println("Is 37 prime? " + isPrime(37));

        IntStream.range(2, 200).filter(Prime::isPrime).forEach(System.out::println);
    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }

//        if ((number * number-1) % 24 == 0) {
//            System.out.println("Print: " + (number * number-1) );
//            return true;
//        }

         return IntStream.range(2, number).anyMatch(value -> number % value == 0) ? false : true;
    }
}
