package com.amb.sample.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ArrayTest {

    @Test
    public void testMaxValNumOfOccurrences() {
        int[] inputArr = {2, 7, 11, 8, 11, 8, 3, 11};
        int[] outputArr = {11, 3};
        Assert.assertArrayEquals(outputArr, maxValCountNumOfOccurrences(inputArr));
        Assert.assertArrayEquals(outputArr, maxValNumOfOccurrences(inputArr));
        Assert.assertEquals("A.S", abbrevName("Ambarish Shinde"));
    }

    @Test
    public void testMaxSumSubarray() {
        int[] inputArr = {-2, -5, 6, -2, -3, 1, 5, -6};
        //SUM({6, -2, -3, 1, 5}) = 7
        Assert.assertEquals(7, maxSumSubarray(inputArr));
    }

    public static int[] countPositivesSumNegatives(int[] inputArr) {
        //int[] inputArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        if (inputArr == null || inputArr.length == 0) {
            return new int[0];
        }
        AtomicInteger positiveCnt = new AtomicInteger(0);
        AtomicInteger sumOfNegative = new AtomicInteger(0);
        IntStream.range(1, inputArr.length).forEach(index -> {
            if (inputArr[index] > 0) {
                positiveCnt.incrementAndGet();
            } else {
                sumOfNegative.addAndGet(inputArr[index]);
            }
        });
        int[] outputArr = new int[2];
        outputArr[0] = positiveCnt.get();
        outputArr[1] = sumOfNegative.get();
        return outputArr; //return an array with count of positives and sum of negatives
    }

    public static String smash(String... words) {
        StringBuilder sentence = new StringBuilder();
        int index = 0;
        for (String word : words) {
            sentence.append(word);
            if (index != words.length)
                sentence.append(" ");
            index++;
        }
        return sentence.toString();
    }

    public static String abbrevName(String name) {
        String[] splitStr = name.split(" ");
        String abbrev = new StringBuilder().append(splitStr[0].charAt(0)).append(".").append(splitStr[1].charAt(0)).toString();
        return abbrev;
    }

    public int maxSumSubarray(int[] nums) {
        return 0;
    }
    private static int[] maxValCountNumOfOccurrences(int[] nums) {
        Map<Integer, Integer> maxValMap = new HashMap<>();
        for (int num: nums) {
            maxValMap.put(num, maxValMap.containsKey(num) ? maxValMap.get(num) + 1 : 1);
        }
        Map.Entry<Integer, Integer> integerEntry = maxValMap.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() > o2.getValue()) return -1;
                    if (o1.getValue() < o2.getValue()) return 1;
                    return 0;
                }).findFirst().get();

        int[] resArr = new int[2];
        resArr[0] = integerEntry.getKey();
        resArr[1] = integerEntry.getValue();
        return resArr;
    }

    private static int[] maxValNumOfOccurrences(int[] nums) {
        Map<Integer, Integer> maxValMap = new TreeMap<>();
        for (int num: nums) {
            maxValMap.put(num, maxValMap.containsKey(num) ? maxValMap.get(num) + 1 : 1);
        }
        Map.Entry<Integer, Integer> integerEntry = maxValMap.entrySet().stream()
                .sorted((entry1, entry2) -> getSortingOrder(entry1, entry2)).findFirst().get();

        int[] responseArr = new int[2];
        responseArr[0] = integerEntry.getKey();
        responseArr[1] = integerEntry.getValue();
        return responseArr;
    }

    private static int getSortingOrder(Map.Entry<Integer, Integer> num1, Map.Entry<Integer, Integer> num2) {
        if (num1.getKey() > num2.getKey()) return -1;
        if (num1.getKey() < num2.getKey()) return 1;
        return 0;
    }
}
