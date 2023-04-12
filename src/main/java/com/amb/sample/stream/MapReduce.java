package com.amb.sample.stream;

import com.amb.sample.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MapReduce {
    public static void main(String[] args) {
        calculateAvgAgeJava8();
        calculateAvgAge();
    }

    private static void calculateAvgAge() {
        List<Employee> list = buildEmployeeList();

        AtomicInteger age = new AtomicInteger(0);
        list.forEach(employee -> {
            age.getAndAdd(employee.getAge());
        });

        System.out.println("Average age: " + age.get()/list.size());
    }

    private static void calculateAvgAgeJava8() {
        List<Employee> list = buildEmployeeList();
        double avg = list.stream().mapToInt(Employee::getAge).average().getAsDouble();

        System.out.println("Average age: " + new BigDecimal(avg).setScale(0, RoundingMode.HALF_UP));
    }

    private static List<Employee> buildEmployeeList() {
        Employee employee = Employee.builder().id(1).name("John").age(21).build();
        Employee employee1 = Employee.builder().id(2).name("Josh").age(22).build();
        Employee employee2 = Employee.builder().id(3).name("Jim").age(41).build();
        Employee employee3 = Employee.builder().id(4).name("Bim").age(33).build();

        List<Employee> list = Arrays.asList(employee1, employee2,employee3, employee);
        return list;
    }
}
