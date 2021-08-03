package mahdi.davoodi;

/*
 * (Solved by me.)
 * Link --->  https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem?h_r=next-challenge&h_v=zen
 * */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            Integer output = Integer.parseInt(input);
            System.out.println(output);
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
    }
}