package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer number: ");
        int n = scanner.nextInt();

        if (n % 2 == 0) System.out.format("%d is an even number.",n);
        else System.out.format("%d is an odd number.",n);
    }
}
