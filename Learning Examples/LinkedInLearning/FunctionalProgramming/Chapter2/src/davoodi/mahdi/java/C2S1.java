package davoodi.mahdi.java;

import java.util.function.Function;

/*This is my own example from the course.*/
public class C2S1 {

    protected static class Plus {
        public static int addTen(int n) {
            return n + 10;
        }

        public static String sayNumber(int n) {
            return "---> The number is " + n;
        }
    }

    public static void main(String[] args) {
        // Add 10 to input.
        Function<Integer, Integer> function = Plus::addTen;
        System.out.println(function.apply(5));

        // Say what is the number in String.
        Function<Integer, String> function2 = Plus::sayNumber;
        System.out.println(function2.apply(27));

    }
}
