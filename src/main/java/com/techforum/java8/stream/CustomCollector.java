package com.techforum.java8.stream;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {
    public static void main(String[] args){
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons = productList().stream().collect(toLinkedList);
        System.out.println(linkedListOfPersons instanceof  LinkedList);
        linkedListOfPersons.stream().forEach(System.out::println);
    }

    private static List<Product> productList(){
        List<Product> products = new ArrayList<>();
        Product product = new Product("AAA", "HOME");
        products.add(product);
        Product product1 = new Product("BBB", "ELE");
        products.add(product1);
        return products;
    }
}

@Data
class Product{
    private String name;

    private String type;

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
