package com.amb.sample.coding;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Fibonacci: " + fib(10));
        System.out.println("===============================");
        printFib(10);
        System.out.println("===============================");
        printFibByArray(11);
        System.out.println("===============================");
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void printFib(int range) {
       int number1 = 0, number2 = 1, count = 0;

       while (count <= range) {
           System.out.println(number1);

           int number3 = number1 + number2;
           number1 = number2;
           number2 = number3;
           count++;
       }
    }

    public static void printFibByArray(int range) {
        int[] arr = new int[range-1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < range; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
