package ir.blog.mahdidavoodi;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Print Values of Answer enum.
        System.out.format("----> Answer Values: %s\n", Arrays.toString(Answer.values()));          // Answer.values is an array!

        // Print Values of Colors enum.
        System.out.format("----> Colors Values: %s\n", Arrays.toString(Colors.values()));

        // Get a Range (EnumSet) of MyColor enum
        EnumSet<Colors> S = EnumSet.range(Colors.Black, Colors.Green);
        System.out.println("----> Values of EnumSet:");
        for (Colors s:S) {
            System.out.format("---->     %s\n", s);
        }
        System.out.println("\n");

        // Parse a String into Answer enum.
        Scanner scanner = new Scanner(System.in);
        System.out.print("----> Please enter a value (Yes/No): ");
        String string = scanner.next();
        Answer A = Answer.valueOf(string);
        System.out.format("Entry: %s\n", A);
    }
}
enum Answer {Yes, No}
