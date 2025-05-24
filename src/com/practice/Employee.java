package com.practice;

import java.util.List;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private List<String> projects;

    public Employee(String name, int age, double salary, List<String> projects) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: $" + salary + " | Projects: " + projects;
    }
}
