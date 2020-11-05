package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public static ArrayList<String> foodCart = new ArrayList<>();
    public static int priceCart = 0;
    Scanner scanner = new Scanner(System.in);

    public void showMenu(Scanner scanner, String className, String[] names, int[] prices) {
        while (true) {
            System.out.println("----> " + className + " menu:");
            int i;
            for (i = 0; i < names.length; i++) {
                System.out.format("%d. ----> \t%d$ --- %s\n", i + 1, prices[i], names[i]);
            }
            System.out.println((i + 1) + ". ----> Back");
            System.out.print("----> "); // i =4
            int enteredNumber = scanner.nextInt();
            if (enteredNumber <= names.length) {
                MainMenu.foodCart.add(names[enteredNumber - 1]);
                MainMenu.priceCart += prices[enteredNumber - 1];
                System.out.println("----> \"" + names[enteredNumber - 1] + "\" added to your cart!");
                start();
                scanner.close();
                break;
            } else if (enteredNumber == (names.length + 1)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                start();
                scanner.close();
                break;
            }
        }
    }

    public void start() {
        System.out.println("~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~ ||| MENU ||| ~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~");
        System.out.println("----> \t \t 1.Foods \t \t 2.FastFoods \t \t 3.Desserts");
        System.out.println("~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~~-~-~");
        System.out.println("----> Other actions:\t 4.Payment \t \t 5.Exit");
        System.out.print("----> ");
        int enteredNumber = scanner.nextInt();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (enteredNumber) {
            case 1:
                Food food = new Food();
                food.showMenu(scanner, food.className, food.names, food.prices);
                break;
            case 2:
                FastFood fastFood = new FastFood();
                fastFood.showMenu(scanner, fastFood.className, fastFood.names, fastFood.prices);
                break;
            case 3:
                Dessert dessert = new Dessert();
                dessert.showMenu(scanner, dessert.className, dessert.names, dessert.prices);
                break;
            case 4:
                if (priceCart == 0) System.out.println("Your cart was empty!");
                else {
                    System.out.println("----> Your cart:");
                    for (int i = 0; i < foodCart.size(); i++) {
                        System.out.format("%d. ----> \t%s\n", i + 1, foodCart.get(i));
                    }
                    System.out.println("~~~ Total Price: " + priceCart + "$");
                }
                break;
            default:
                System.out.println("----> Have a nice day. Goodbye!");
        }
    }
}
