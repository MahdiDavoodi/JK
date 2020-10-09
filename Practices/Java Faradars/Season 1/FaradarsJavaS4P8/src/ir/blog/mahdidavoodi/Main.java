package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter an integer: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int counter = 0;
        System.out.format("Divisors of %d\n", n);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.format("%d\n", i);
                counter++;
            }
        }
        System.out.format("----> %d has %d divisors.\n",n,counter);
        if (counter ==2 ) System.out.format("---------> %d is a Prime number.",n);
        else System.out.format("---------> %d is NOT a Prime number.",n);
    }
}
