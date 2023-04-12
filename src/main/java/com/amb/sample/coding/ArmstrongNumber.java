package com.amb.sample.coding;

/**
 * An Armstrong number of three digit is a number whose sum of cubes of its digit is equal * to its number.
 * For example 153 is an Armstrong number * of 3 digit because 1^3+5^3+3^3 or 1+125+27=153
 * <p>
 */
public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmStrongNum(153));
        System.out.println(isArmStrongNum(222));
    }

    private static boolean isArmStrongNum(int number) {
        int result = 0;
        int orig = number;
        while (number != 0) {
            int remainder = number % 10;
            result = result + (remainder * remainder * remainder);
            number = number / 10;
        }
        if (orig == result) {
            return true;
        }
        return false;
    }
}
