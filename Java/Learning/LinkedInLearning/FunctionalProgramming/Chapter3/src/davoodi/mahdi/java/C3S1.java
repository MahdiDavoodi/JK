package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*An example for using .map built-in function for write better code.
 * .map gets a stream and returns stream.
 * In this example we want to divide each number in the list by 2.*/
public class C3S1 {

    public static void main(String[] args) {
        // Common way.
        Integer[] input = {2, 4, 6, 8, 10, 12, 48, 120};
        Integer[] output = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i] / 2;
        }
        System.out.println(Arrays.toString(output));

        // Better way.
        List<Integer> firstList = new ArrayList<>(Arrays.asList(input));

        Function<Integer, Integer> divideByTwo = x -> x / 2;
        List<Integer> secondList = firstList.stream().map(divideByTwo).collect(Collectors.toList());
        System.out.println(secondList);
    }
}
