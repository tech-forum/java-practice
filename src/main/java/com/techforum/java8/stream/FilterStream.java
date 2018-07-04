package com.techforum.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterStream {

    public static void main(String[] args){
        //filter elements with criteria
        Stream<String> stream = countryList().stream().filter(str -> str.startsWith("U"));
        printStream(stream);

        //stream becomes inaccessible when terminal operation is called on it. like stream.findAny(), stream.findFirst()

    }

    private static void printStream(Stream strStream) {
        strStream.forEach(System.out::println);
        System.out.println("********");
    }

    public static List<String> countryList(){
        List<String> list = new ArrayList<>();
        list.add("IND");
        list.add("US");
        list.add("UK");
        list.add("AUS");
        return list;
    }
}
