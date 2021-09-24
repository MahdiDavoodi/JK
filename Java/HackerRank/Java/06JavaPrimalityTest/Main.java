package mahdi.davoodi;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        if (new BigInteger(new Scanner(System.in)
                .nextLine().trim())
                .isProbablePrime(1))
            System.out.println("prime");
        else
            System.out.println("not prime");
    }
}
/*
 * This is a challenge from HackerRank.
 * Link --> https://www.hackerrank.com/challenges/java-primality-test/problem
 * New concepts: BigInteger class.
 * */