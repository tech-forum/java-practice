package com.amb.sample.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private int id;

    private String name;

    private int age;
    private String department;
}
