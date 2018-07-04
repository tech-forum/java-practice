package com.techforum.java8.stream;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Data
public class BuildStream {

    public static void main(String[] args) throws IOException {
        //using Stream.of
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);
        printStream(integerStream);

        //using list stream
        Stream<String> listStream = getCountryList().stream();
        printStream(listStream);

        //using string of char
        String str = "IND,US,UK,AUS,SA";
        Stream<String> strStream = Stream.of(StringUtils.split(str, ",")); //Stream.of(str.split(","));
        StringUtils.split(str, ",");
        printStream(strStream);
        Stream<String> strStream1 = Pattern.compile(",").splitAsStream(str);
        printStream(strStream1);

        //Stream of file
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\java-examples\\src\\main\\resources\\file.txt");
        Stream<String> fileStream = Files.lines(path);
        printStream(fileStream);

        //using Builder
        Stream<String> stream = Stream.<String>builder().add("AAA").add("BBB").add("CCC").build();
        printStream(stream);

        //using generate
        Stream<String> generatedStream = Stream.generate(()->"GENERATE").limit(5);
        printStream(generatedStream);

        //using iterate
        Stream<String> iterateStream = Stream.iterate("ITERATE", n -> n).limit(6);
        printStream(iterateStream);

        //stream of primitives
        //range(int startInclusive, int endExclusive) method creates an ordered stream
        IntStream intStream = IntStream.range(100,110);
        intStream.forEach(System.out::println);
        System.out.println("********");

        //rangeClosed(int startInclusive, int endInclusive) method does the same, only second element is included
        LongStream longStream = LongStream.rangeClosed(505,515);
        longStream.forEach(System.out::println);
        System.out.println("********");

        //using ThreadLocalRandom
        IntStream intStream1 = ThreadLocalRandom.current().ints().limit(5);
        intStream1.forEach(System.out::println);
        System.out.println("********");
    }

    private static void printStream(Stream strStream) {
        strStream.forEach(System.out::println);
        System.out.println("********");
    }

    public static List<String> getCountryList(){
        List<String> list = new ArrayList<>();
        list.add("IND");
        list.add("US");
        list.add("UK");
        list.add("AUS");
        return list;
    }
}
