package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Food extends MainMenu {
    String className = "Food";
    String[] names = {"Kabab", "Jooje", "Ghorme Sabzi", "Gheime", "Zereshkpolo", "Makarooi", "Fesenjan"};
    int[] prices = {12, 10, 15, 8, 8, 7, 20};

    @Override
    public void showMenu(Scanner scanner, String className, String[] names, int[] prices) {
        super.showMenu(scanner, className, names, prices);
    }
}
