package mahdi.davoodi;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = new BigInteger(scanner.nextLine().trim());
        BigInteger b = new BigInteger(scanner.nextLine().trim());
        scanner.close();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
/*
 * This is an easy challenge from HackerRank.
 * Link --> https://www.hackerrank.com/challenges/java-biginteger/problem
 * New concepts: BigInteger class. Another usage.
 * */