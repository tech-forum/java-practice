package com.amb.sample.coding;

/**
 * * Java program to demonstrate How to find Greatest Common Divisor or GCD of
 * * two numbers using Euclid’s method. There are other methods as well to
 * * find GCD of two number in Java but this example of finding GCD of two number
 * * is most simple.
 *
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        ///System.out.println("GCD of two numbers 54 and 24: " + findGCD(54, 24));
        System.out.println("GCD of two numbers 324 and 27: " + findGCD(324, 28));
        //System.out.println("GCD of two numbers 525 and 50: " + findGCD(525, 50));
    }

    public static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }
}
