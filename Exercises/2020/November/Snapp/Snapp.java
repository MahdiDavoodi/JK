package ir.blog.mahdidavoodi;


import java.io.IOException;
import java.util.Scanner;

public class Snapp {

    private final Account account = new Account();
    private final City city = new City();
    private final AccountLogs accountLogs = new AccountLogs();

    public void appStart() throws IOException {
        boolean b = loginMenu();
        if (b) {
            if (account.login())
                mainMenu();
        } else if (account.createAccount()) mainMenu();
    }

    public void mainMenu() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(Main.ANSI_BLUE + "-----> Please choose what you wanna do." + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> 1. Trip" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> 2. Account Logs" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> 3. Exit" + Main.ANSI_RESET);
        System.out.print("---> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                tripMenu();
                break;
            case 2:
                accountLogs.showLogs(account.currentUsername);
                mainMenu();
                break;
            default:
                System.out.println(Main.ANSI_BLUE + "-----> Goodbye!" + Main.ANSI_RESET);
        }

    }

    public boolean loginMenu() {
        System.out.println(Main.ANSI_BLUE
                + "-----> Hello! Please choose login or create an account.[L/C]"
                + Main.ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("---> ");
            String input = scanner.next().trim();
            if (input.equalsIgnoreCase("L")) return true;
            else if (input.equalsIgnoreCase("C")) return false;
        }
    }

    public void tripMenu() throws IOException {
        System.out.println(Main.ANSI_BLUE + "-----> Please choose your starting city:" + Main.ANSI_RESET);
        city.showCityList();
        boolean validCity = false;
        String input;
        System.out.print("---> ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().trim();
        for (int i = 0; i < city.cityNames.length; i++) {
            if (input.equalsIgnoreCase(city.cityNames[i])) {
                city.setStartingCity(input);
                city.setStartingCityCoordinatesX(city.cityCoordinates[i][0]);
                city.setStartingCityCoordinatesY(city.cityCoordinates[i][1]);
                validCity = true;
                break;
            }
        }
        if (!validCity) {
            System.out.println(Main.ANSI_RED + "-----> Invalid City" + Main.ANSI_RESET);
            return;
        }
        System.out.println(Main.ANSI_BLUE + "-----> Now please choose your target city:" + Main.ANSI_RESET);
        validCity = false;
        System.out.print("---> ");
        input = scanner.nextLine().trim();
        for (int i = 0; i < city.cityNames.length; i++) {
            if (input.equalsIgnoreCase(city.cityNames[i])) {
                city.setTargetCity(input);
                city.setTargetCityCoordinatesX(city.cityCoordinates[i][0]);
                city.setTargetCityCoordinatesY(city.cityCoordinates[i][1]);
                validCity = true;
                break;
            }
        }
        if (!validCity) {
            System.out.println(Main.ANSI_RED + "-----> Invalid City" + Main.ANSI_RESET);
            return;
        }
        accountLogs.saveLog(account.currentUsername, city.getStartingCity(), city.getTargetCity());
        Trip trip = new Trip(city.getStartingCityCoordinatesX(), city.getStartingCityCoordinatesY(), city.getTargetCityCoordinatesX(), city.getTargetCityCoordinatesY());
        trip.normalTrip(city.getStartingCity(), city.getTargetCity());
        mainMenu();
    }
}
