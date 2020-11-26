package ir.blog.mahdidavoodi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap {
    public static void main(String[] args) {
        /*
         * Map is another interface that contains objects.
         * The deference between Map and Collection(and its childes) is that Map has a table(Key,Value) form.
         * We can have duplicate and same values but we can not have same keys.
         * We can set type of key and value like this: Map<String, Integer>. Key ---> String, Value ---> Integer.
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(12345678, "Google.com");
        map.put(87654321, "Amazon.com");
        map.put(12345678, "Apple.com");
        System.out.println(map.containsKey(12345678));
        // It will return the last value we added to the same key: Apple.com
        for (String s : map.values()) {
            System.out.println(s);
        }
        /*
         * We can extract all keys and values in set and collection.
         * All keys in a Set (You and I both know why we use set in here :) )
         * And all values in a collection.
         * */
        Set<Integer> set = map.keySet();
        Collection<String> collection = map.values();
    }
}
