package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class FastFood extends MainMenu {
    String className = "FastFood";
    String[] names = {"Pizza", "Hamburger", "Hot Dog", "Chips", "French Sandwich"};
    int[] prices = {9, 7, 4, 3, 5};

    @Override
    public void showMenu(Scanner scanner, String className, String[] names, int[] prices) {
        super.showMenu(scanner, className, names, prices);
    }
}
