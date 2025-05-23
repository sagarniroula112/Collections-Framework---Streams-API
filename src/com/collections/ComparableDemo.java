package com.collections;

import java.util.ArrayList;
import java.util.List;

class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public int compareTo(Product p) {
        return this.name.compareTo(p.name);
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
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]\n";
    }
}

public class ComparableDemo {
    // Comparable - It is an interface, that sorts according to the natural order of elements.
    // It defines a method called int compareTo(T o);
    // By default, for using integers, strings and floating numbers, you don't have to override compareTo() method.
    // But for objects, it is compulsory.

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(103, "Table", 149.50, "Furniture"));
        products.add(new Product(102, "Smartphone", 499.99, "Electronics"));
        products.add(new Product(104, "Chair", 89.99, "Furniture"));
        products.add(new Product(105, "Pen", 2.99, "Stationery"));
        products.add(new Product(101, "Laptop", 999.99, "Electronics"));
        products.add(new Product(106, "Notebook", 3.99, "Stationery"));

        products.sort(null); // FOR COMPARABLE, JUST PASS "null".
        System.out.println(products);

    }
}
