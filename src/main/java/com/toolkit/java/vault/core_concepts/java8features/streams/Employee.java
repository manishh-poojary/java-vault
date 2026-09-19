package com.toolkit.java.vault.core_concepts.java8features.streams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
