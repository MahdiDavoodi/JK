package mahdi.davoodi;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < list.size(); i++)
            for (int j = list.size(); j > i; j--)
                if (list.subList(i, j).stream().reduce(0, Integer::sum) < 0) count++;
        System.out.println(count);
    }
}
/*
 * This is a challenge from HackerRank.
 * Link --> https://www.hackerrank.com/challenges/java-negative-subarray/problem
 * */