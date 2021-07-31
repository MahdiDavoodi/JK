package davoodi.mahdi.java;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Example for composition.
 * A way to make more complex functions with .andThen and .compose*/
public class C4S4 {
    public static void main(String[] args) {
        Function<String, String> beforeFirstSpace = string -> string.split(" ")[0];
        Function<String, Integer> numOfChars = String::length;

        Function<String, Integer> numOfChars_beforeFirstSpace = beforeFirstSpace.andThen(numOfChars);

        System.out.println(numOfChars_beforeFirstSpace.apply("Hello Mahdi!"));
    }
}
