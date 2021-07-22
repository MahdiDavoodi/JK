package ir.blog.mahdidavoodi;

import java.util.Objects;
import java.util.function.Predicate;

/*
 * Java 8 Predicate, Lambda and Method reference example.
 * */
public class PredicateEx {
    public static void main(String[] args) {
        String s = "Java";
        Predicate<String> notEmpty = (string) -> string.length() > 0;
        System.out.println("----> String is not empty: " + notEmpty.test(s)); // true.
        System.out.println("----> String is empty: " + notEmpty.negate().test(s)); // false.

        Predicate<String> notNull = Objects::nonNull; // (string) -> string != null;
        System.out.println("----> String is not null and empty: " + notNull.and(notEmpty).test(s)); // true.

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("----> String is empty: " + isEmpty.test(s)); // false.
    }
}
