package davoodi.mahdi.java;

import java.util.function.BiFunction;

/*
 * In this example I learned that we can pass functions like variables.
 * It means we can get the behavior and apply that to fix data.*/
public class C2S5 {
    protected static class Numbers {
        private static Integer add(int x, int y) {
            return x + y;
        }

        private static Integer divide(int x, int y) {
            return x / y;
        }

        private static Integer the9And3(BiFunction<Integer, Integer, Integer> function) {
            // Fixed data but different behavior.
            return function.apply(9, 3);
        }

        private static Integer the2And3(BiFunction<Integer, Integer, Integer> function) {
            return function.apply(2, 3);
        }
    }

    public static void main(String[] args) {
        // It will return the sum of 9 and 3.
        System.out.println(Numbers.the9And3(Numbers::add));

        // Divided 9 by 3.
        System.out.println(Numbers.the9And3(Numbers::divide));

        // Multiply by using lambda.
        System.out.println(Numbers.the2And3((x, y) -> x * y));
    }
}
