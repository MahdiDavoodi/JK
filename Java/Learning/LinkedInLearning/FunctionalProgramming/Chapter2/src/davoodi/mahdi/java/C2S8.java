package davoodi.mahdi.java;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * An example for using HIGHER ORDER FUNCTION to write better codes.
 * In this case, we want each method do 1 thing and not worry about other things.
 * If our method is doing many different things, It's better to divide that method to 2 or more.
 */
public class C2S8 {
    public static void main(String[] args) {
        // For divide.
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        // For safe divide.
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> safeDivide =
                fun -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: Can NOT divide by zero!");
                        return 0f;
                    } else return fun.apply(x, y);
                };

        BiFunction<Float, Float, Float> safeDiv = safeDivide.apply(divide);
        System.out.println(safeDiv.apply(12f, 12f));
    }
}
