package com.amb.sample.coding;

import java.util.*;
import java.util.stream.Stream;

public class ArrayOps {
    public static void main(String[] args) {
//        findMinAndMx();
//        reverseArray();
//        sortArray();
//        sortArrayUsingWhile();
        removeDuplicate();
    }

    private static void findMinAndMx() {
        int[] arr = {10, 23, 9, 67, 33, 55, 3};

        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.println("min: " + min + " max: " + max);
    }

    private static void reverseArray() {
        int[] arr = {10, 23, 9, 67, 33, 55, 3};
        int[] rev = new int[arr.length];

        int index = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            rev[index] = arr[i];
            index++;
        }
        printArray(rev);
    }

    private static void sortArray() {
        int[] arr = {10, 23, 9, 67, 33, 55, 3};

        for (int fw = 0; fw < arr.length; fw++) {
            int temp = 0;
            for (int bk = fw + 1; bk < arr.length; bk++) {
                if (arr[bk] < arr[fw]) {
                    temp = arr[bk];
                    arr[bk] = arr[fw];
                    arr[fw] = temp;
                }
            }
        }
        printArray(arr);
    }

    private static void sortArrayUsingWhile() {
        int[] arr = {10, 23, 9, 67, 33, 67, 55, 3};

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > temp) {
                arr[j] = arr[j-1];
                j --;
            }
            arr[j] = temp;
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(value -> {
            System.out.print(value + " ");
        });
    }

    private static void removeDuplicate() {
        int[] arr = {10, 23, 9, 67, 33, 67, 55, 33};

        int[] output = Arrays.stream(arr).distinct().toArray();
        printArray(output);
    }

}
