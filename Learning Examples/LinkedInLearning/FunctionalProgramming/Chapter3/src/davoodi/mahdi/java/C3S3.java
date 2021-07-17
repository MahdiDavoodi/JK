package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class C3S3 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> input = new ArrayList<>(Arrays.asList(array));

        BinaryOperator<Integer> factorial = (begin, x) -> begin * x;
        Integer output = input.stream()
                .reduce(1, factorial);

        System.out.println("---> 10! = " + output);
    }
}
