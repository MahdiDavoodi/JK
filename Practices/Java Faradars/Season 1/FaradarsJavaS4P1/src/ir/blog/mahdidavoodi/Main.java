package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer [1 to 7]: ");
        int n = scanner.nextInt();
        String day;
        if (n == 1) day = "Saturday";
        else if (n == 2) day = "Sunday";
        else if (n == 3) day = "Monday";
        else if (n == 4) day = "Tuesday";
        else if (n == 5) day = "Wednesday";
        else if (n == 6) day = "Thirsday";
        else if (n == 7) day = "Friday";
        else day = "";
        if (!day.equals("")) System.out.format("The day # %d in week is %s.\n", n, day);
        else System.out.println("You have entered an invalid number!");
    }
}
