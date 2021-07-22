package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C3S2 {
    public static void main(String[] args) {
        String[] strings = {"Hello", "This", "is", "Mahdi"};
        List<String> input = new ArrayList<>(Arrays.asList(strings));

        Function<Character, Predicate<String>> findChar =
                character -> (string) -> string.indexOf(character) > 0;

        List<String> output = input.stream()
                .filter(findChar.apply('l'))
                .collect(Collectors.toList());

        System.out.println(output);
    }
}
