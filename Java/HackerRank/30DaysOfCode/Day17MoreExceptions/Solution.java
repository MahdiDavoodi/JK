package mahdi.davoodi;

/*
 * (Solved by me.)
 * Link --->  https://www.hackerrank.com/challenges/30-more-exceptions/problem
 * */

import java.util.Scanner;

class Solution {
    private static class Calculator {
        public static int power(int a, int b) throws Exception {
            if (a < 0 || b < 0)
                throw new Exception("n and p should be non-negative");
            else
                return (int) Math.pow(a, b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        while (rows > 0) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();

            try {
                System.out.println(Calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            rows--;
        }
        scanner.close();
    }
}