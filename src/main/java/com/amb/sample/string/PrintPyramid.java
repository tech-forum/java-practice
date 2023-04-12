package com.amb.sample.string;

import java.util.stream.IntStream;

public class PrintPyramid {
    public static void main(String[] args) {
        printTriagle();
        printPyramidMiddle();
        drawPyramidPattern();
        printNumberPyramid();
    }

    private static void printTriagle() {
        IntStream.range(1, 10).forEach(value -> {
            int index = value;
            while (index > 0) {
                System.out.print("* ");
                index--;
            }
            System.out.println("");
        });
    }
    private static void printPyramidMiddle() {
        int max = 10;
        IntStream.range(1, max).forEach(value -> {

            int blank = (max)-value;
            while (blank > 0 ) {
                System.out.print(" ");
                blank--;
            }

            int index = value;
            while (index > 0) {
                System.out.print("* ");
                index--;
            }
            System.out.println("");
        });
    }

    private static void printNumberPyramid() {
        int max = 10;
        IntStream.range(1, max).forEach(value -> {

            int blank = (max)-value;
            while (blank > 0 ) {
                System.out.print(" ");
                blank--;
            }

            int index = value;
            while (index > 0) {
                System.out.print(value + " ");
                index--;
            }
            System.out.println("");
        });
    }


    public static void drawPyramidPattern() {
        int max = 10;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
