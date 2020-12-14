package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----> ax + b = 0");
        System.out.print("-----------> Please enter a: ");
        int a = scanner.nextInt();
        System.out.print("-----------> Please enter b: ");
        int b = scanner.nextInt();
        EquationSolver.SolveEq1(a,b);
    }
}
