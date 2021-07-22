package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Get the number from the user
        System.out.println("Hello. Please insert the number.");
        System.out.print("--------->");
        Scanner scanner = new Scanner(System.in);
        final int theNumber = scanner.nextInt();
        scanner.close();

        // Factorial
        long theFactorialResult = theFactorial(theNumber);
        System.out.println("The factorial result is: " + theFactorialResult);
        System.out.println("-----------------------------------------------");

        // Fibonacci
        long theFibonacciResult = theFibonacci(theNumber);
        System.out.println("The fibonacci result is: " + theFibonacciResult);
        System.out.println("-----------------------------------------------");

        // Perfect number
        String thePerfectNumberResult = thePerfectNumber(theNumber);
        System.out.println(thePerfectNumberResult);
        System.out.println("-----------------------------------------------");

        // Even or Odd number
        String theEvenOrOddResult = theEvenOrOdd(theNumber);
        System.out.println(theEvenOrOddResult);
        System.out.println("-----------------------------------------------");

        // The number of prime numbers (Less than theNumber)
        int theNumberOfPrimeResult = theNumberOfPrime(theNumber);
        System.out.println(theNumberOfPrimeResult);
        System.out.println("-----------------------------------------------");

    }


    private static int theNumberOfPrime(int theNumber) {
        int result = 0;
        if (theNumber > 1) {
            for (int i = 2; i <= theNumber; i++) {
                if (isNotPrime(i) == false) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isNotPrime(int N) {
            for (int j = 2; j < N ; j++) {
                if ((N % j) == 0){
                     return true;
                }
            }
            return false;
    }

    private static String theEvenOrOdd(int theNumber) {
        if ((theNumber % 2) == 0) {
            return "The number is an Even number.";
        } else {
            return "The number is an Odd number.";
        }
    }

    private static String thePerfectNumber(int theNumber) {
        int[] divisor = new int[theNumber];
        int n = 0, divisorSum = 0;
        for (int i = 1; i < theNumber; i++) {
            if ((theNumber % i) == 0) {
                divisor[n] = i;
                n++;
            }
        }
        for (int i = n; i >= 0; i--) {
            divisorSum = divisorSum + divisor[i];
        }
        if (divisorSum == theNumber) {
            return "That number is a perfect number.";
        } else {
            return "That number is NOT a perfect number.";
        }
    }

    private static long theFibonacci(int theNumber) {
        if(theNumber < 3) return 1;
        return theFibonacci(theNumber-1) + theFibonacci(theNumber-2);
    }

    private static long theFactorial(int theNumber) {
        if (theNumber == 1) return 1;
        return (theNumber * theFactorial(theNumber-1));
    }


}
