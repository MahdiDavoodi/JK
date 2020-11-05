package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("----> Please enter the number: ");
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextFloat();
        int counter = 0, counter_max = 3;
        do {
            System.out.format("%.2f \n", n);
            n /= 2;
            counter++;
        } while (n >= 1 && counter < counter_max);
    }
}
