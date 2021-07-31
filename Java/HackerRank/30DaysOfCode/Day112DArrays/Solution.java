package mahdi.davoodi;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

/*
 * In this example we needed for-for loop!
 * (Solved by myself.)
 * Link --->  https://www.hackerrank.com/challenges/30-2d-arrays/problem
 * */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> array = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                array.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        final int n = array.size();
        int max = Integer.MIN_VALUE, temp;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                temp = array.get(i).get(j) + array.get(i).get(j + 1) + array.get(i).get(j + 2)
                        + array.get(i + 1).get(j + 1)
                        + array.get(i + 2).get(j) + array.get(i + 2).get(j + 1) + array.get(i + 2).get(j + 2);

                if (max < temp)
                    max = temp;
            }
        }
        System.out.println(max);
    }
}