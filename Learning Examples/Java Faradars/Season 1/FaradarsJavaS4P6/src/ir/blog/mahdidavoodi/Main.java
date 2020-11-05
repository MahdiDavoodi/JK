package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float n;
        String s;
        while (true) {
            System.out.print("Please enter a number: ");
            n = scanner.nextFloat();
            System.out.format("%f\t%f\t%f\n", n, Math.pow(n, 2), Math.pow(n, 3));
            System.out.println("Do you want to continue? [Y/N]");
            s = scanner.next().toUpperCase();
            if (!s.startsWith("Y")) break;
        }
    }
}
