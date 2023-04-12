package com.amb.sample.coding;

import com.amb.sample.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You have an array of numbers.
 * Your task is to sort ascending odd numbers but even numbers must be on their places.
 * Zero isn't an odd number, and you don't need to move it. If you have an empty array, you need to return it.
 * Example
 * sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 */
public class SortTheOdd {
    public static void main(String[] args) {
        Integer[] numberArray = new Integer[] {5, 3, 2, 8, 1, 4};
        List<Integer> unsortedList =  Arrays.asList(numberArray);
        List<Integer> sortedList = unsortedList.stream().sorted((o1, o2) -> {
            if(o2 != 0 && o2 % 2 == 0) {
                return 0;
            } else if(o2 < o1){
                return -1;
            } else return 1;
        }).collect(Collectors.toList());
        System.out.println("sortedList" + sortedList);

        Employee employee = Employee.builder()
                .id(1)
                .department("COMP")
                .build();
        System.out.println("employee " + employee);
    }
}
