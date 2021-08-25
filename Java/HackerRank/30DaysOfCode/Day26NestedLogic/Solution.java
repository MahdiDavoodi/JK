package mahdi.davoodi;
/*
 * (Solved by me.)
 * 30 Days of code - HackerRank - Day 26: Nested Logic
 * Link ---> https://www.hackerrank.com/challenges/30-nested-logic/problem
 * */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] returned = Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] expected = Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int fee = fee(returned, expected);
        System.out.println(fee);
    }

    private static int fee(int[] returnDate, int[] expectedDate) {
        if (takeFee(returnDate, expectedDate)) {
            if (returnDate[2] == expectedDate[2]) {
                // They are in the same year.
                if (returnDate[1] == expectedDate[1]) {
                    // They are in the same month.
                    return 15 * (returnDate[0] - expectedDate[0]);
                } else return 500 * (returnDate[1] - expectedDate[1]);
            } else return 10000;
        } else return 0;
    }

    private static boolean takeFee(int[] returnDate, int[] expectedDate) {
        if (expectedDate[2] > returnDate[2])
            return false;
        else if (expectedDate[2] == returnDate[2]
                && expectedDate[1] > returnDate[1])
            return false;
        else return expectedDate[2] != returnDate[2]
                    || expectedDate[1] != returnDate[1] ||
                    expectedDate[0] < returnDate[0];
    }
}