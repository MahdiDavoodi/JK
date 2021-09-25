package mahdi.davoodi;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            scanner.nextLine();
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("insert")) {
                list.add(scanner.nextInt(), scanner.nextInt());
            } else {
                list.remove(scanner.nextInt());
            }
        }
        for (int n : list)
            System.out.print(n + " ");
    }
}
/*
 * This is a challenge from HackerRank. Suitable for JDK15.
 * Link --> https://www.hackerrank.com/challenges/java-list/problem
 * Concepts: List and its famous methods.
 * */