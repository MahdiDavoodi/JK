package ir.blog.mahdidavoodi;

import java.util.stream.IntStream;

/*
 * An example for using parallel.
 * It will create some threads to do the thing faster.
 * */
public class StreamEx4 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 4_000)
                .parallel()
                .filter(x -> x % 1_000 == 0)
                .forEach(System.out::println);
    }
}
