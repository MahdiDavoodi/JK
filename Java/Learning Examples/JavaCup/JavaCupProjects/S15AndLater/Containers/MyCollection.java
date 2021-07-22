package ir.blog.mahdidavoodi;

import java.util.Collection;
import java.util.HashSet;

public class MyCollection {
    /*
     * Collection is father of the Set and List interfaces.
     * It has some methods like: add, remove, size, and any other methods that both Set and List have it.*/
    public static void main(String[] args) {
        Collection<Integer> collection = new HashSet<>();
        collection.add(4);
        collection.add(1);
        collection.add(2);
        System.out.println("---> The collection size: " + collection.size());
        for (Integer integer : collection) {
            System.out.println(integer);
        }
        // And We can extract an array in collection (Set or List).
        Integer[] integers = collection.toArray(new Integer[collection.size()]);

        System.out.println("---> The extracted array size: " + integers.length);
    }
}
