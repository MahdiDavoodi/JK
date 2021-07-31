package ir.blog.mahdidavoodi;

import java.util.stream.IntStream;

/*
 * It will print Prime Numbers between 2 and 100.
 * */
public class StreamEx3 {
    public static void main(String[] args) {
        IntStream.range(2, 100)
                .filter(a -> IntStream.range(2, a - 1)
                        .noneMatch(x -> a % x == 0))
                .forEach(System.out::println);
    }
}
