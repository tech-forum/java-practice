package com.amb.sample.string;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatingChars {

    public static void main(String[] args) {
        printNonRepeatingChar("aaabbcdeff");
    }

    private static void printNonRepeatingChar(String input) {
        Map<String, Integer> list = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            String key = String.valueOf(c);
            list.put(key, list.containsKey(key) ? list.get(key) + 1 : 1);
        }

        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            if (val == 1) {
                System.out.println(input + ": first non repeating char: " + key);
                break;
            }
        }

    }
}
