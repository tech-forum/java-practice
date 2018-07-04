package com.techforum.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        //filter operation
        Stream<String> filteredStream = countryStream().filter(s -> s.startsWith("U"));
        printStream(filteredStream);

        //map operation
        Stream<String> mappedStream = countryStream().filter(s-> !s.startsWith("U")).map(s -> s.concat("_"));
        printStream(mappedStream);

        //sorted operation
        Stream<String> sortedStream = countryStream().sorted().map(s -> s.concat("#"));
        printStream(sortedStream);

        //terminal operation
        //foreach
        countryStream().filter(s -> s.startsWith("U")).forEach( System.out::println);
        System.out.println("********");

        //collect
        List collectedList = countryStream().filter(s-> !s.contains("I")).collect(Collectors.toList());
        printStream(collectedList.stream());

        //map
        System.out.println(countryStream().allMatch(s->s.startsWith("U")));
        System.out.println(countryStream().anyMatch(s->s.equals("IND")));
        System.out.println(countryStream().noneMatch(s->s.equals("CAN")));
        System.out.println("********");

        //count
        System.out.println(countryStream().filter(s-> s.startsWith("U")).count());
        Optional<String> reduced = countryStream().reduce((s1, s2)->s1+"#"+s2);
        reduced.ifPresent(System.out::println);
        System.out.println("********");

        //findFirst
        System.out.println(countryStream().filter(s-> s.startsWith("U")).findFirst().get());
        System.out.println("********");

        //parallel stream
        Stream<String> parallelStream = countryList().parallelStream();
        parallelStream.filter(s->s.contains("U")).collect(Collectors.toList()).forEach(System.out::println);
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
