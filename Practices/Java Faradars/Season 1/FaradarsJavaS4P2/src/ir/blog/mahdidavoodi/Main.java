package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day, type;
        System.out.print("Please enter an integer [1 to 7]: ");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                day = "Saturday";
                break;
            case 2:
                day = "Sunday";
                break;
            case 3:
                day = "Monday";
                break;
            case 4:
                day = "Tuesday";
                break;
            case 5:
                day = "Wednesday";
                break;
            case 6:
                day = "Thirsday";
                break;
            case 7:
                day = "Friday";
                break;
            default:
                day = "";
        }
        switch (n) {    // Case grouping.
            case 1:
            case 3:
            case 5:
                type = "Even";
                break;
            case 2:
            case 4:
            case 6:
                type = "Odd";
                break;
            case 7:
                type = "";
                break;
            default:
                type = "";
        }
        if (!day.isEmpty()) {
            System.out.format("The day # %d in week is %s.\n", n, day);
            if (!type.isEmpty()) System.out.format("%s is an %s day.\n", day, type);    // We can use isEmpty() for checking string.
            else System.out.format("%S is not an Even or Odd number.\n", day);   // %S makes the String capslock form.
        } else System.out.println("You have entered an invalid number!");
    }
}
