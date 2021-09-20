package mahdi.davoodi;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine().trim();
            try {
                Pattern.compile(input);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
    }
}
/*
 * This is an exercise from HackerRank.
 * Link ---> https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
 * */