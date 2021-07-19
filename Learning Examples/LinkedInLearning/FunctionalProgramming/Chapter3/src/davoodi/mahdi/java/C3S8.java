package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Parallel stream example.
 * How to create and show how does ot works.(with threads)*/
public class C3S8 {
    public static void main(String[] args) {
        String[] strings = {"Code", "Java", "Android", "College", "Canada"};
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        List<String> filteredList =
                list.parallelStream()
                        .filter(word -> {
                            System.out.println("--# processing " + word);
                            return word.length() >= 5;
                        })
                        .collect(Collectors.toList());

        System.out.println(filteredList);
    }
}
