package mahdi.davoodi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int n, leap;
            n = scanner.nextInt();
            leap = scanner.nextInt();
            scanner.nextLine();
            List<Integer> list = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            if (winOrLose(n, leap, list, 0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean winOrLose(int n, int leap, List<Integer> list, int start) {
        if (start < 0 || list.get(start) == 1)
            return false;
        else if (start + leap >= n || start == n - 1)
            return true;
        list.set(start, 1);
        return winOrLose(n, leap, list, start + 1)
                || winOrLose(n, leap, list, start + leap)
                || winOrLose(n, leap, list, start - 1);
    }
}
/*
 * This is an exercise from HackerRank.
 * Link ---> https://www.hackerrank.com/challenges/java-1d-array/problem
 * Got help from community. Help: Filling visited indexes with 1 to avoid loop.
 * */