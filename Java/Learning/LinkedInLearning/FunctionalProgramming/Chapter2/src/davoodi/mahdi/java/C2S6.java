package davoodi.mahdi.java;

import java.util.function.Function;

/*
 * In this example I learned how to return function in functions.
 * The main reason for that is, We can change the behavior and prevent similar functions and codes.
 * Do the exact same things without repeating the same code of functions.*/
public class C2S6 {
    protected static class Example {
        private static final MyNoArgFunction<MyNoArgFunction<String>> createHello =
                () -> () -> "Hello Functions!";

        /* Instead of doing this, we can replace with returning functions.

        private static Integer add5(int x) {
            return x + 5;
        }

        private static Integer add20(int x) {
            return x + 20;
        }

        private static Integer add35(int x) {
            return x + 35;
        }*/

        private static Function<Integer, Integer> addY(int y) {
            return x -> x + y;
        }
    }

    public static void main(String[] args) {
        // Return a function which returns a string.
        MyNoArgFunction<String> hello = Example.createHello.apply();
        System.out.println(hello.apply());

        // You can create functions without repeat the code.
        // In this case we create custom function that gets 5 as Y and 10 as X.
        System.out.println(Example.addY(5).apply(10));
        System.out.println(Example.addY(8).apply(20));
        System.out.println(Example.addY(4).apply(10));
    }
}
