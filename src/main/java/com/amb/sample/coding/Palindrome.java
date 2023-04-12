package com.amb.sample.coding;

import java.util.stream.Stream;

public class Palindrome {
    public static void main(String[] args) {
        isPalindromeJava8("abcd");
        isPalindromeJava8("aba");
        isPalindromeJava8("bbbbbbbb");
    }

    private static boolean isPalindrome(String input) {

        char[] chars = input.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            reverse.append(chars[i]);
        }
        boolean isPalindrome = input.equals(reverse.toString());
        System.out.println(input + " is palindrome? " + isPalindrome);
        return isPalindrome;
    }

    private static boolean isPalindromeJava8(String input) {

        String reverse = new StringBuilder(input).reverse().toString();

        boolean isPalindrome = input.equals(reverse.toString());
        System.out.println(input + " is palindrome? " + isPalindrome);
        return isPalindrome;
    }

    private static boolean isPalindromeRecursive(String input) {
        boolean isPalindrome = input.equals(reverse(input));
        System.out.println(input + " is palindrome? " + isPalindrome);
        return isPalindrome;
    }
    private static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

}
