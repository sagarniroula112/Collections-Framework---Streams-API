package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CollectionDemoInteger {
    // Collection -> Acts like a bag, full of items of similar type.
    // Collections -> It is a Utility class, which helps perform certain types of functions like
    // sort(), min(), etc.

    public static void main(String[] args) {
        // 1. Integer
        // 2. String
        // 3. Objects(Student)

        // FOR INTEGER

        List<Integer> nums = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));

        Collection<Integer> numsCollection = nums;
        // BASIC MODIFICATION
        // 1. add(Object o)
        numsCollection.add(65);
        System.out.println(nums);
        System.out.println(numsCollection.size());

        // 2. addAll(Collection<? extends E> c)
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(5,8));

        nums2.add(9);
        System.out.println(nums2);
        System.out.println(nums2.size());

        numsCollection.addAll(nums2);
        System.out.println(nums);
        System.out.println(numsCollection.size());

        // 3. remove(Object o)
        numsCollection.remove(10); // Object can be of type that is specified (here it is integer).
       numsCollection.add(8);
        numsCollection.remove(8); // Removes first occurrence of 8.
        System.out.println(numsCollection);
        System.out.println(numsCollection.size());

        // 4. removeAll(Collection<?> c)
       numsCollection.removeAll(nums2);
       System.out.println(numsCollection);
       System.out.println(numsCollection.size());

       // 5. clear()
       numsCollection.clear();
       System.out.println(numsCollection);
       System.out.println(numsCollection.size());

       //QUERYING
       // 6. contains(Object o)
       System.out.println(nums2);
       System.out.println(nums2.size());
       System.out.println(nums2.contains(8));

       // 7. containsAll(Collection <?> c)
       numsCollection.add(1);
       numsCollection.add(2);
       numsCollection.add(3);
       numsCollection.add(5);
       numsCollection.add(9);
       numsCollection.add(8);
       System.out.println(numsCollection);
       System.out.println(numsCollection.size());
       System.out.println(numsCollection.containsAll(nums2));
       System.out.println("---------------------------------------------------------");

       // 8. isEmpty()
       System.out.println(numsCollection.isEmpty());
    //    numsCollection.clear();
    //    System.out.println(numsCollection.isEmpty());

        // 9. size()
        System.out.println(numsCollection);
        System.out.println(numsCollection.size());
        System.out.println("---------------------------------------------");

        // FOR ITERATION
        // 10. iterator()
        Iterator<Integer> iterator = numsCollection.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 11. forEach()
        System.out.println("-----------------------------------------------------");
        numsCollection.forEach(num -> System.out.println(num));

        // 12. removeIf(Predicate<? super E> filter)
        Predicate<Integer> pred = t -> {
            return t>5;   
        };
        numsCollection.removeIf(pred);
        System.out.println(numsCollection);
        System.out.println(numsCollection.size());
        System.out.println("---------------------------------------------");

        // 13. toArray()
        System.out.println(Arrays.toString(numsCollection.toArray()));

        System.out.println("*************** COLLECTION DEMO COMPLETED WITH IMP METHODS *****************");
    }
}
