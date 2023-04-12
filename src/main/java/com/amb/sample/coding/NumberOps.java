package com.amb.sample.coding;

public class NumberOps {
    public static void main(String[] args) {
//        swapNumbers();
        reverseNumber(325);
    }

    private static void swapNumbers() {
        int num1 = 12;
        int num2 = 35;

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("num1: " + num1 + " num2: " + num2);
    }

    private static int reverseNumber(int number) {
        boolean isNegative = number < 0 ? true : false;
        if (isNegative) {
            number = number * -1;
        }
        int reverse = 0;
        int lastDigit = 0;
        while (number >= 1) {
            lastDigit = number % 10; // gives you last digit
            reverse = reverse * 10 + lastDigit;
            number = number / 10; // get rid of last digit
        }
        reverse = isNegative == true ? (reverse * -1) : reverse;
        System.out.println("Reverse: " + reverse);
        return reverse;
    }
}
