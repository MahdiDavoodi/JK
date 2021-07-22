package davoodi.mahdi.java;

import java.util.function.BiFunction;

/*
 * In this example I learned to use BiFunction interface.
 * You can create functions with 2 parameters (Function interface gets 1) with it.
 * Also you can create your own Function interface very simple.(Look at My... Interfaces)
 * */
public class C2S3 {
    public static void main(String[] args) {
        // Create functions with 2 parameters.
        BiFunction<Integer, Integer, String> sum =
                (x, y) -> " " + (x + y);

        System.out.println(sum.apply(13, 2));

        // Custom functions with custom parameters.
        MyNoArgFunction<Integer> getThree = () -> 3;
        System.out.println(getThree.apply());

        MyThreeArgsFunction<Integer, Integer, Integer, Integer> multiply =
                (x, y, z) -> x * y * z;
        System.out.println(multiply.apply(1, 2, 3));
    }
}
