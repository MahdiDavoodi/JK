package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Ebay {
    UserManagement userManagement = new UserManagement();
    Store store = new Store();
    Purchase purchase = new Purchase();


    protected void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---> Please choose what you want to do: \t 1. Login. \t\t 2. Create an account.");
        System.out.print("--> ");
        int enteredNumber = scanner.nextInt();
        if (enteredNumber == 1) {
            System.out.print("---> Username: ");
            String email = scanner.nextLine().trim();
            email = scanner.nextLine().trim();
            System.out.print("---> Password: ");
            String password = scanner.nextLine().trim();
            if (userManagement.loginUser(email, password)) {
                System.out.println("---> Logged in!");
                mainMenu();
            } else {
                System.out.print("---> Login failed! Goodbye.");
            }
        } else if (enteredNumber == 2) {
            System.out.print("---> Username: ");
            String newEmail = scanner.nextLine().trim();
            newEmail = scanner.nextLine().trim();
            System.out.print("---> Password: ");
            String newPassword = scanner.nextLine().trim();
            System.out.print("---> FirstName: ");
            String name = scanner.nextLine().trim();
            System.out.print("---> Wallet Balance: ");
            int walletBalance = scanner.nextInt();
            if (userManagement.createUser(newEmail, newPassword, name, walletBalance)) {
                userManagement.saveUsersData("UsersData.json");
                System.out.println("---> Account Created! Goodbye.");
            } else {
                System.out.println("---> Account creation failed! Goodbye.");
            }
        } else
            System.out.println("---> Wrong request! Goodbye.");


    }

    protected void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        menu:
        while (true) {
            System.out.println("---> Please choose what you want to do.");
            System.out.println("1. Start Shopping. \t \t 2. Edit wallet balance. \t \t 3. Remove this Account. \t \t 4. Exit.");
            System.out.print("--> ");
            int enteredNumber = scanner.nextInt();
            switch (enteredNumber) {
                case 1:
                    shoppingMenu();
                    break menu;
                case 2:
                    System.out.print("---> Ok. Now please enter the money you want to add: ");
                    System.out.println("---> Your new balance is + " + UserManagement.editWalletBalance(scanner.nextInt()));
                    mainMenu();
                    break menu;
                case 3:
                    if (userManagement.removeUser())
                        System.out.println("---> User removed! Goodbye.");
                    userManagement.saveUsersData("UsersData.json");
                    break menu;
                default:
                    System.out.println("---> Goodbye!");
                    userManagement.saveUsersData("UsersData.json");
                    break menu;
            }
        }
    }

    private void shoppingMenu() {
        menu:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---> OK. Here we go. Your wallet has: " + UserManagement.editWalletBalance(0) + " $");
            System.out.println("---> Choose: 1. Products list \t \t 2. Pay. \t \t 3. Show current purchase list");
            System.out.print("--> ");
            switch (scanner.nextInt()) {
                case 1:
                    store.showProductMenu();
                    System.out.print("--> ");
                    if (store.selectProducts(scanner.nextInt())) {
                        purchase.addProductToCart();
                    } else {
                        System.out.println("---> You don't have enough money!");
                    }
                    break;
                case 2:
                    if (purchase.newPurchase()) {
                        System.out.println("---> Done!");
                        purchase.saveReceiptsData("ReceiptsData.json");
                        userManagement.saveUsersData("UsersData.json");
                        store.saveProductsData("ProductsData.json");
                        break menu;
                    } else {
                        System.out.println("---> Your cart is empty!");
                    }
                    break;
                case 3:
                    purchase.showPurchaseList();
                    break;
                default:
                    break;
            }
        }
    }

}
