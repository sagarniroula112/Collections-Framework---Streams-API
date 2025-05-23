package com.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product1 {
    private int id;
    private String name;
    private double price;
    private String category;

    public Product1(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product11 [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]\n";
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        // Comparator: It is an interface defined in java.util
        // It compares two objects and returns a value depending on certain conditions.
        // It has an abstract method: public int compare(Object o1, Object o2);

        List<Product1> Product1s = new ArrayList<>();
        Product1s.add(new Product1(103, "Table", 149.50, "Furniture"));
        Product1s.add(new Product1(102, "Smartphone", 499.99, "Electronics"));
        Product1s.add(new Product1(104, "Chair", 89.99, "Furniture"));
        Product1s.add(new Product1(105, "Pen", 2.99, "Stationery"));
        Product1s.add(new Product1(101, "Laptop", 999.99, "Electronics"));
        Product1s.add(new Product1(106, "Notebook", 3.99, "Stationery"));

        // Sorting by Product1 Name

        Comparator<Product1> comp = Comparator.comparing((Product1 p)->p.getName()).thenComparing((Product1 p)->p.getId()).reversed();
        Product1s.sort(comp);
        System.out.println(Product1s);

        // Comparator<Product1> comp = new Comparator<>() {
        //     @Override
        //     public int compare(Product1 p1, Product1 p2) {
        //         return Double.compare(p2.getPrice(), p1.getPrice());
        //     }
        // };

        // Comparator<Product1> comp = (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice());

        // Product1s.sort(comp);
        // System.out.println(Product1s);
    }
}
