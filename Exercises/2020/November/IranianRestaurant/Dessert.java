package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Dessert extends MainMenu {
    String className = "Desserts";
    String[] names = {"Chocolate Cake", "Strawberry Cake", "Vanilla Cake", "Milk", "Ice Cream"};
    int[] prices = {5, 5, 3, 2, 1};

    @Override
    public void showMenu(Scanner scanner, String className, String[] names, int[] prices) {
        super.showMenu(scanner, className, names, prices);
    }
}

