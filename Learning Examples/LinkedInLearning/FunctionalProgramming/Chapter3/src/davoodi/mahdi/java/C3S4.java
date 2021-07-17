package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C3S4 {
    public static void main(String[] args) {
        String[] string_array = {"Java", "Kotlin", "C#", "United States", "Android", "Canada"};
        List<String> strings = new ArrayList<>(Arrays.asList(string_array));


        // joining
        String output1 = strings.stream().collect(Collectors.joining("-/-/-"));
        System.out.println(output1);

        // counting
        Long output2 = strings.stream().filter(string -> string.length() > 6).collect(Collectors.counting());
        System.out.println("Long words count is = " + output2);

        // grouping by
        Map<Integer, List<String>> output3 = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(output3);

        // par
        Map<Boolean, List<String>> output4 = strings.stream().collect(Collectors.partitioningBy(
                word -> word.length() > 6
        ));
        System.out.println(output4);
    }
}
