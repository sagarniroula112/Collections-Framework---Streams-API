package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PracticeTask {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Alice", 28, 55000, Arrays.asList("Alpha", "Beta")),
            new Employee("Bob", 34, 72000, Arrays.asList("Beta")),
            new Employee("Charlie", 26, 48000, Arrays.asList("Alpha")),
            new Employee("Diana", 40, 90000, Arrays.asList("Gamma", "Delta")),
            new Employee("Ethan", 30, 61000, Arrays.asList("Beta", "Gamma")),
            new Employee("Fiona", 29, 59000, Arrays.asList("Delta")),
            new Employee("George", 45, 105000, Arrays.asList("Alpha", "Gamma")),
            new Employee("Hannah", 32, 67000, Arrays.asList("Beta", "Delta"))
        ));

        System.out.println(employees.size());

        // 1. Filtering & Matching

        List<String> allEmpNames = employees.stream().map(s->s.getName()).toList();
        System.out.println(allEmpNames);
        List<String> allNames = allEmpNames.stream().filter(s -> s.startsWith("J")).toList();
        System.out.println(allNames);

        Predicate<String> pred = s -> s.contains("J");
        // boolean nameContainsA = allNames.stream().filter(pred);
        boolean nameContainsA = allEmpNames.stream().anyMatch(pred);
        System.out.println(nameContainsA);

        Predicate<String> pred2 = s ->  s.length() > 3;
        boolean allGreaterThanThree = allEmpNames.stream().allMatch(pred2);
        System.out.println(allGreaterThanThree);

        Predicate<String> pred3 = s -> s.length() == 0;
        boolean noEmptyName = allEmpNames.stream().noneMatch(pred3);
        System.out.println(noEmptyName);

        // 2. Distinct, Limit, Skip

        List<List<String>> projectsList = employees.stream().map(e->e.getProjects()).toList();
        System.out.println(projectsList);

        projectsList.stream().distinct().limit(3)
                    .forEach(n->System.out.println(n));

        System.out.println("--------------------------------------------");
        projectsList.stream().skip(2).forEach(p->System.out.println(p));
        System.out.println("--------------------------------------------");
        
        employees.stream().filter(e->e.getAge() > 30).skip(1).limit(1).forEach(e->System.out.println(e));

        // 3. Transformation with map()

        
    }
}
