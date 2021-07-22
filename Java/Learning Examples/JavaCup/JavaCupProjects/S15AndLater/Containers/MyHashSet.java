package ir.blog.mahdidavoodi;

import java.util.HashSet;

public class MyHashSet {
    /*
     * Difference between Set and List:
     * 1. We do not have any methods that work with index. Cuz we don't have any index in Set.
     * 2. We can not have duplicate objects. (Same objects)
     * 3. We don't have any order in set
     * */
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello Java!");
        hashSet.add("Goodbye Kotlin!");
        hashSet.add("Hello Java!");
        System.out.println(hashSet.size()); // It will print 2
    }

}
