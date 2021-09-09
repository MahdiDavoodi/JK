package mahdi.davoodi;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * This is a Java challenge from HackerRank.
 * Link ---> https://www.hackerrank.com/challenges/java-currency-formatter/problem
 * */
public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double input = scanner.nextDouble();

        // US - India - China - France
        System.out.println("US: " + NumberFormat.getCurrencyInstance(
                Locale.US
        ).format(input));

        // Needs to create Locale for India by "en" and "in" parameters.
        System.out.println("India: " + NumberFormat.getCurrencyInstance(
                new Locale("en", "in")
        ).format(input));

        System.out.println("China: " + NumberFormat.getCurrencyInstance(
                Locale.CHINA
        ).format(input));

        System.out.println("France: " + NumberFormat.getCurrencyInstance(
                Locale.FRANCE
        ).format(input));
    }
}