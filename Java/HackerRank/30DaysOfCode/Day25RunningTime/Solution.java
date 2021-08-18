package mahdi.davoodi;
/*
 * (Solved by me. Little help from discussion.)
 * 30 Days of code - HackerRank - Day 25: Running time and complexity
 * Link ---> https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
 * My solution couldn't complete "test case 9". So I replaced (i < input / 2) with (i * i <= input).
 * */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            int input = scanner.nextInt();
            primeChecker(input);
            n--;
        }
    }

    static void primeChecker(int input) {
        boolean isPrime = true;
        if (input < 2)
            isPrime = false;
        else
            for (int i = 2; i * i <= input; i++) {
                if (input % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        if (isPrime)
            System.out.println("Prime");
        else
            System.out.println("Not prime");
    }
}

