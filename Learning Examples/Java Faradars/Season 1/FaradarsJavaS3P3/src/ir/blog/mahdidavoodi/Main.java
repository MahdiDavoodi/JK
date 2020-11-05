package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int n = scanner.nextInt();
        String type = (n % 2 == 0) ? "even" : "odd";
        System.out.format("The number %d is an %s number.", n, type);
    }
}
