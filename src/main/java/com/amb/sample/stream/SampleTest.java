package com.amb.sample.stream;

import com.amb.sample.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SampleTest {

    public static void main(String[] args) {

        SampleTest sampleTest = new SampleTest();
        List<Employee> empList = sampleTest.getEmplyees();

        //print department with id 2
        empList.stream()
                .filter(emp -> 2 == emp.getId())
                .forEach(System.out::println);

        //group ids by departments
        empList.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment()))
                .forEach((s, employees) -> System.out.println("Department:"+s+" Number of Employees:"+employees.size()+" "+employees));
    }

    private List<Employee> getEmplyees() {
        List<Employee> empList = new ArrayList<>();
        empList.add(Employee.builder().id(1).department("IT").build());
        empList.add(Employee.builder().id(2).department("HR").build());
        empList.add(Employee.builder().id(3).department("Admin").build());
        empList.add(Employee.builder().id(4).department("Finance").build());
        empList.add(Employee.builder().id(5).department("IT").build());
        empList.add(Employee.builder().id(6).department("IT").build());
        return empList;
    }
}

