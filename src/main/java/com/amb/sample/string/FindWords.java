package com.amb.sample.string;

import java.util.*;
import java.util.stream.Collectors;

public class FindWords {
    public static void main(String[] args) {
        countWords();
        System.out.println("=================================");
        countWordsLegacy();
    }

    private static void countWords() {
        String stat = "John is engineer John live in house Engineer is John house is fun";
        String[] words = stat.toLowerCase().split(" ");

        Arrays.stream(words).collect(Collectors.groupingBy(s -> s)).forEach((key, val) -> {
            System.out.println(key + " : " + val.size());
        });
    }

    private static void countWordsLegacy() {
        String stat = "John is engineer John live in house Engineer is John house is fun";
        String[] words = stat.toLowerCase().split(" ");

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        wordMap.forEach((key, val) -> {
            System.out.println(key + " : " + val);
        });
    }
}
