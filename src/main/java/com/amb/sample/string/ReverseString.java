package com.amb.sample.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "ABCDABCD";

        StringBuilder reverseStr = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i = arr.length-1; i >= 0; i--) {
            reverseStr.append(arr[i]);
        }

        System.out.println(reverseStr);
    }
}
