package ir.blog.mahdidavoodi;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
 * A simple example for using Stream options.
 * It will calculate the sum of words length.
 * (words that starts with "Hello")
 * */
public class StreamOptionsEx {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("Hello Linux!");
        strings.add("Hello Android!");
        strings.add("Hello Kotlin!");
        strings.add("Hello Google!");
        strings.add("Goodbye Java!");

        Optional<Integer> sum = strings.stream()
                .filter(s -> s.startsWith("Hello"))
                .map(String::length) // s -> s.length()
                .reduce(Integer::sum); // (a,b) -> a + b

        sum.ifPresent(System.out::println);

    }
}
