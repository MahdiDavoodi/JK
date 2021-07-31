package davoodi.mahdi.java;

import java.util.function.Function;

/*My lambda expressions examples with functions.*/
public class C2S2 {
    public static void main(String[] args) {
        // If the integer is above 0, it will multiply to 3.
        Function<Integer, Integer> tripleIfMoreThanZero =
                n -> n < 0 ? n : n * 3;
        System.out.println(tripleIfMoreThanZero.apply(5));

        // Get count of space character.
        Function<String, Long> numberOfSpace =
                string -> string.chars().filter(ch -> ch == ' ').count();
        System.out.println(numberOfSpace.apply("Hello World. This is Mahdi!"));
    }
}
