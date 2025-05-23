package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CollectionDemoString {
    public static void main(String[] args) {
        // Creating a List of Strings
        List<String> strings1 = new ArrayList<>(Arrays.asList("Hello", "World", "is", "the", "first", "Sentence"));
        System.out.println(strings1);

        // 1. add(Object o) - Add a single element
        strings1.add("Optional");
        System.out.println(strings1);

        // Creating another Collection of Strings
        Collection<String> strings2 = new ArrayList<>(Arrays.asList("I", "am", "added", "After"));
        System.out.println(strings2);

        // 2. addAll(Collection<? extends E> c) - Add all elements from another collection
        strings1.addAll(strings2);
        System.out.println(strings1);

        // 3. remove(Object o) - Remove a single specified element
        strings1.remove("Optional");
        System.out.println(strings1);

        // 4. removeAll(Collection<?> c) - Remove all elements that are also in the given collection
        // strings1.removeAll(strings2);
        // System.out.println(strings1);

        // 5. clear() - Remove all elements from the collection
        // strings1.clear();
        // System.out.println(strings1);

        // QUERYING

        // 6. contains(Object o) - Check if the collection contains a specific element
        System.out.println(strings1.contains("Optional")); // false
        System.out.println(strings1.contains("the")); // true

        // 7. containsAll(Collection <?> c) - Check if all elements from another collection are present
        System.out.println(strings1.containsAll(strings2)); // true

        // 8. isEmpty() - Check if the collection is empty
        System.out.println(strings1.isEmpty());

        // 9. size() - Get the number of elements
        System.out.println(strings1.size());

        // FOR ITERATION

        // 10. iterator() - Iterate through the collection using Iterator
        Iterator<String> iter = strings1.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("-------------------------------------------");

        // 11. forEach() - Lambda-based iteration
        strings2.forEach(str -> System.out.println(str));
        System.out.println("-------------------------------------------");

        // 12. removeIf(Predicate<? super E> filter) - Remove elements conditionally using a lambda
        Predicate<String> pred = (String str) -> {
            return str.contains("am");
        };
        strings2.removeIf(pred);
        System.out.println(strings2);

        // 13. toArray() - Convert collection to array
        System.out.println(Arrays.toString(strings2.toArray()));
    }
}
