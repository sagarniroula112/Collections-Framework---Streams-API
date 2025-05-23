package com.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    // Collection stores the data while stream processes the data.
    // Collection is used for storage while stream is used for computation on them.
    
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "China", "Charlie");

        // FILTERING & MATCHING

        // 1. filter(Predicate)

        Predicate<String> pred = (String s) -> {
            return s.startsWith("C");
        };

        names.stream()
            .filter(pred)
            .forEach(System.out::println);

        System.out.println("------------------------------------------");

        // 2. distinct()

        names.stream()
            .filter(pred)
            .distinct()
            .forEach(System.out::println);
        
        System.out.println("------------------------------------------");

        // 3. limit(n)
        names.stream()
            .filter(pred)
            .distinct()
            .limit(1)
            .forEach(System.out::println);

        System.out.println("------------------------------------------");

        // 4. skip(n)
        names.stream()
            .filter(pred)
            .distinct()
            .skip(1)
            .limit(1)
            .forEach(System.out::println);

        System.out.println("------------------------------------------");

        // 5. anyMatch(Predicate)
        boolean anyStartsWithC = names.stream()
                .anyMatch(s->s.startsWith("C"));
        System.out.println(anyStartsWithC);

        // 6. allMatch(Predicate)
        boolean allStartWithC = names.stream()
                .allMatch(s->s.startsWith("C"));
        System.out.println(allStartWithC);

        // 7. noneMatch(Predicate)
        boolean noneStartWithC = names.stream()
                .allMatch(s->s.startsWith("C"));
        System.out.println(noneStartWithC);

        System.out.println("***********************************************");

        // FOR TRANSFORMATION AND SORTING (MIXED)

        // 8. map(Function)
        List<Integer> allNums = new ArrayList<>();
        allNums.add(10);
        allNums.add(5);
        allNums.add(2);
        allNums.add(15);
        allNums.add(8);

        // System.out.println(allNums.size());

        Comparator<Integer> comp = Comparator.comparingInt(n -> n);

        Stream<Integer> numsNaya = allNums.stream()
                .map((Integer n) -> n * 2).sorted(comp);  // sorts in ascending with Comparable

        Stream<String> nayaString = names.stream()
                .map(str -> str+"hi").limit(1);
        
        numsNaya.forEach(System.out::println);
        nayaString.forEach(System.out::println);


        // FOR TERMINAL OPERATIONS

        // 9. forEach(Consumer)
        // numsNaya.forEach(n->System.out.println(n));

        // 10. count()
        List<Integer> toCheckCount = new ArrayList<>();
        toCheckCount.add(10);
        toCheckCount.add(5);
        toCheckCount.add(2);
        toCheckCount.add(15);
        toCheckCount.add(8);

        // System.out.println(toCheckCount.stream().count());
        System.out.println("---------------------------------------------");

        // 11. collect(Collector)
        toCheckCount.stream().collect(Collectors.toCollection(() -> new LinkedHashSet<>())).forEach(n->System.out.println(n));
        // LinkedHashSet maintains order.

        System.out.println("----------------------------------------------");

        // 12. reduce(...)
        Optional<Integer> op = toCheckCount.stream().reduce((c,e) -> (c+e)); // Returns Optional object
        System.out.println(op.get());

        // 13. min(Comparator)
        Comparator<Integer> cmp = (a,b) -> Integer.compare(a, b);
        Optional<Integer> minVal = toCheckCount.stream().min(cmp);
        System.out.println(minVal);

        // 14. max(Comparator)
        Optional<Integer> maxVal = toCheckCount.stream().max(cmp);
        System.out.println(maxVal);

        // 15. findFirst()
        Optional<Integer> firstOne = toCheckCount.stream().findFirst();
        System.out.println(firstOne);

        // 16. findAny()
        Optional<Integer> anyOne = toCheckCount.stream().findAny();
        System.out.println(anyOne);

        
        // FOR COLLECTORS (used with collect())

        // 17. Collectors.toList()
        List<Integer> newList = toCheckCount.stream().collect(Collectors.toList());
        System.out.println(newList);

        // 18. Collectors.toSet()
        Set<Integer> newSetList = toCheckCount.stream().collect(Collectors.toSet());
        System.out.println(newSetList);

        // 19. Collectors.toMap()
        Map<String, Integer> newMap = toCheckCount.stream().collect(Collectors.toMap(n-> "Key-" + n, n-> n));
        System.out.println(newMap);
    }
}
