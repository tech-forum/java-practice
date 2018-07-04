package com.techforum.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduceOperation {
    public static void main(String[] args) {
        //basic reduce
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        reduced.ifPresent(System.out::println); //1 + 2 + 3 = 6
        System.out.println("***********");

        //two param reduce
        int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println(reducedTwoParams); //10 + 1 + 2 + 3 = 16
        System.out.println("***********");

        //three param reduce //TODO: Not clear
        int reducedThreeParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println("combiner called: "+a+":"+b);
            return a+b;
        });
        System.out.println(reducedThreeParams); //10 + 1 + 2 + 3 = 16
        System.out.println("***********");

        //

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
