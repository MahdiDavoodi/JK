package ir.blog.mahdidavoodi;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Another examples of Stream.
 * Just print 1 to 20 in 2 lines.
 * Or print even numbers.
 * */
public class StreamEx2 {
    public static void main(String[] args) {
        IntStream oneTo19 = IntStream.range(1, 20);
        IntStream oneTo20 = IntStream.rangeClosed(1, 20);
        Stream.iterate(0, x -> x + 2)
                .limit(10) // We have to set a limit.
                .forEach(System.out::println);
        oneTo19.forEach(System.out::println);
        oneTo20.forEach(System.out::println);
    }
}
