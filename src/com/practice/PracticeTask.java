package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

        List<String> allUpperNames = allEmpNames.stream().map(name -> name.toUpperCase()).toList();
        System.out.println(allUpperNames);

        List<Double> doubledSalary = employees.stream().map(e -> e.getSalary() * 2).toList();
        System.out.println(doubledSalary);

        projectsList.stream().map(l -> l + " - Project Member").toList().forEach(i->System.out.println(i));

        // 4. Sorting
        
        Comparator<Employee> comp = Comparator.comparing(e->e.getAge());
        employees.stream().sorted(comp).forEach(e->System.out.println(e));

        // Comparator<List<String>> comp1 = Comparator.comparing(i->);
        employees.stream().flatMap(e -> e.getProjects().stream()).distinct().sorted().forEach(i->System.out.println(i));

        // 5. Reduction and Aggregation

        Optional<Double> sum = employees.stream().map(e -> e.getSalary()).reduce((c,e)->c+e);
        System.out.println(sum);
        
        Comparator<Employee> comp2 = Comparator.comparing(e->e.getSalary());
        Optional<Employee> emp = employees.stream().min(comp2);
        System.out.println(emp);

        Comparator<Employee> comp3 = Comparator.comparing(e->e.getAge());
        Optional<Employee> empAge = employees.stream().max(comp3);
        System.out.println(empAge);

        // 6. Collectors Usage

        LinkedHashSet<Employee> linkedEmployees = employees.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedEmployees);
        System.out.println("-----------------------------------------------------------");

        Map<String, List<Employee>> groupedByAge = employees.stream().collect(Collectors.groupingBy(e -> {
            if(e.getAge() < 30) return "Young";
            else if(e.getAge() >= 30 && e.getAge() <= 50) return "Mid";
            else return "Senior";
        }));

        System.out.println(groupedByAge);
        System.out.println("-----------------------------------------------------------");

        Map<Boolean, List<Employee>> partitionedGroups = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
        System.out.println(partitionedGroups);
        System.out.println("-----------------------------------------------------------");

        // 7. Counting and Averaging

        Map<String, Long> countByAge = employees.stream().collect(Collectors.groupingBy(e -> {
            if(e.getAge() < 30) return "Young";
            else if(e.getAge() >= 30 && e.getAge() <= 50) return "Mid";
            else return "Senior";
        }, Collectors.counting()));

        System.out.println(countByAge);

        double averageSalary = employees.stream().collect(Collectors.averagingDouble(e->e.getSalary()));
        System.out.println(averageSalary);

        // 8. Joining

        String joinedNames = employees.stream().map(e->e.getName()).collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        String projectNames = employees.stream().flatMap(e-> e.getProjects().stream()).distinct().collect(Collectors.joining("; "));
        System.out.println(projectNames);

        // REVISE THIS flatMap() when required. It is important.
    }
}
