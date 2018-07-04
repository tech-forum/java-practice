package com.techforum.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStream {
    public static void main(String[] args) {
        //convert stream to list, set
        List<String> countryList = countryStream().collect(Collectors.toList());
        countryList.forEach(System.out::println);
        System.out.println("********");

        //convert stream to array
        String[] countryArr = countryStream().toArray(String[]::new);
        Arrays.asList(countryArr).forEach(System.out::println);
        System.out.println("********");

        //convert stream to list and filter countries starts with U
        List<String> countryList1 = countryStream().filter(name -> name.startsWith("U")).collect(Collectors.toList());
        countryList1.forEach(System.out::println);
        System.out.println("********");
    }



    private static void printStream(Stream strStream) {
        strStream.forEach(System.out::println);
        System.out.println("********");
    }

    public static Stream<String> countryStream() {
        return countryList().stream();
    }

    public static List<String> countryList() {
        List<String> list = new ArrayList<>();
        list.add("IND");
        list.add("US");
        list.add("UK");
        list.add("AUS");
        return list;
    }
}
