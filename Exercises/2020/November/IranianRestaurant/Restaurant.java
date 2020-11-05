package ir.blog.mahdidavoodi;

public class Restaurant {

    final String restaurantName = "Persian";
    final String restaurantAddress = "Iran - Karaj - Azimie - 23th Street.";

    public void showMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
