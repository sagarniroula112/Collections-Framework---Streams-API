package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class Student {
    private int roll;
    private String name;
    private int grade; // 1-10
    private String address;

    public Student(int roll, String name, int grade, String address) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
        this.address = address;
    }

    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student [roll=" + roll + ", name=" + name + ", grade=" + grade + ", address=" + address + "]";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Student s = (Student) o;
        return s.roll == this.roll;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(roll);
    }
}

public class CollectionDemoObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", 5, "New York"));
        students.add(new Student(102, "Bob", 6, "Los Angeles"));
        students.add(new Student(103, "Charlie", 4, "Chicago"));
        // students.add(new Student(104, "Diana", 5, "Houston"));
        // students.add(new Student(105, "Ethan", 7, "Phoenix"));
        // students.add(new Student(106, "Fiona", 3, "Philadelphia"));
        // students.add(new Student(107, "George", 6, "San Antonio"));
        // students.add(new Student(108, "Hannah", 8, "San Diego"));
        // students.add(new Student(109, "Ian", 2, "Dallas"));
        // students.add(new Student(110, "Jane", 9, "San Jose"));
        // System.out.println(students);

        students.add(new Student(69, "Sagar", 12, "Dhulabari"));
        System.out.println(students);
        
        // YOU NEED BOTH equals() and hashCode() overridden functions to know which object to remove based on what.
        students.remove(new Student(69, "hjsad", 11, "sjkhadkjsd"));
        System.out.println(students);

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student(102, "Bob", 6, "Los Angeles"));
        
        students.removeAll(students2);
        System.out.println("---------------------------------------------------");
        System.out.println(students);

        // students2.clear();
        // System.out.println(students2);

        // FOR QUERYING

        // COMPARES BASED ON ROLL NUMBER(roll)
        System.out.println(students.contains(new Student(103, "jksad", 5, "khjsadja")));

        students2.add(new Student(103, "kjsjbad", 5, "kshjadbvc"));
        students2.add(new Student(101, "kjsjbad", 5, "kshjadbvc"));
        students.add(new Student(102, "Bob", 6, "Los Angeles"));
        
        System.out.println(students);
        System.out.println(students2);
        System.out.println(students.containsAll(students2));

        // students2.clear();
        System.out.println(students2.isEmpty());

        System.out.println(students.size());

        // FOR ITERATION
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        students.forEach(s -> System.out.println(s));

        Predicate<Student> pred = (Student s) -> {
            return s.getRoll()>=102;
        };

        students.removeIf(pred);
        System.out.println("-----------------------------------------");
        System.out.println(students);

        System.out.println("--------------------------------------------");
        System.out.println(Arrays.toString(students2.toArray()));

        System.out.println("************************************ COMPARATOR ***************************************");

        Comparator<Student> comp = Comparator.comparing((Student s) -> s.getGrade()).thenComparing((Student s) -> s.getName());
        // students2.sort(comp);
        // System.out.println(students2);

        // Comparator<Student> comp2 = Comparator.comparing(s -> s.getName());
        // students2.sort(comp2);
        // System.out.println(students2);

        students.clear();
        students.add(new Student(106, "Charlie", 6, "Pune"));
        students.add(new Student(104, "Alice", 5, "Mumbai"));
        students.add(new Student(102, "Bob", 5, "Delhi"));
        students.add(new Student(107, "David", 7, "Chennai"));
        students.add(new Student(105, "Eve", 6, "Kolkata"));
        students.add(new Student(103, "Zack", 5, "Bangalore"));

        students.sort(comp);
        System.out.println("-----------------------------");
        System.out.println(students);
    }
}
