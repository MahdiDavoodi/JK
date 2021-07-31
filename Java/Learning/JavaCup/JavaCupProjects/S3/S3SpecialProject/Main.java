package ir.blog.mahdidavoodi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("----> Enter the number of members: ");
        int arraySize = scanner.nextInt();

        long[] ids = new long[arraySize];
        String[] names = new String[arraySize];
        char[] genders = new char[arraySize];
        byte[] ages = new byte[arraySize];
        boolean[] filledElements = new boolean[arraySize];     // initially: all false
        long lastID = 1;

        boolean runLoop = true;
        do {
            mainMenu();
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addMember(ids, names, genders, ages, filledElements, lastID, scanner);
                    lastID++;
                    break;
                case 2:
                    removeMember(filledElements, ids, scanner);
                    break;
                case 3:
                    editMember(ids, names, genders, ages, filledElements, scanner);
                    break;
                case 4:
                    showMember(ids, names, genders, ages, filledElements, scanner);
                    break;
                default:
                    runLoop = false;
                    break;
            }
        } while (runLoop);

        scanner.close();
    }

    private static void showMember(long[] ids, String[] names, char[] genders, byte[] ages, boolean[] filledElements, Scanner scanner) {

        System.out.print("----> Enter the member id:");
        long id = scanner.nextLong();
        int foundIndex = -1;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id && filledElements[i]) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex < 0) {
            System.out.println("----> ID not found!");
        } else {
            System.out.println("----> Name:" + names[foundIndex]);
            System.out.println("----> Age:" + ages[foundIndex]);
            System.out.println("----> Gender:" + genders[foundIndex]);
        }
    }

    private static void editMember(long[] ids, String[] names, char[] genders, byte[] ages, boolean[] filledElements, Scanner scanner) {


        System.out.print("----> Enter the member id:");
        long id = scanner.nextLong();
        int foundIndex = -1;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id && filledElements[i]) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex < 0) {
            System.out.println("----> ID not found!");
        } else {
            System.out.print("----> New Name:");
            names[foundIndex] = scanner.nextLine().trim();
            System.out.print("----> New Gender:");
            genders[foundIndex] = scanner.nextLine().trim().charAt(0);// Should be improved!
            System.out.print("----> New Age:");
            ages[foundIndex] = scanner.nextByte();
        }
    }

    private static void removeMember(boolean[] filledElements, long[] ids, Scanner scanner) {
        System.out.print("----> Enter the member id:");
        long id = scanner.nextLong();
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id && filledElements[i]) {
                filledElements[i] = false;
                return;
            }
        }
        System.out.println("----> ID not found!");

    }

    private static void addMember(long[] ids, String[] names, char[] genders, byte[] ages, boolean[] filledElements, long lastID, Scanner scanner) {

        int readyIndex;
        for (readyIndex = 0; readyIndex < filledElements.length; readyIndex++)
            if (!filledElements[readyIndex])
                break;

        System.out.print("---> Enter the name:");
        names[readyIndex] = scanner.nextLine().trim();
        System.out.print("---> Enter the gender:");
        genders[readyIndex] = scanner.next().trim().charAt(0);    // We have to do it better guys :).
        System.out.print("---> Enter the age:");
        ages[readyIndex] = scanner.nextByte();

        ids[readyIndex] = lastID;
        filledElements[readyIndex] = true;

        System.out.println("---> New member ID: " + lastID);
    }

    private static void mainMenu() {

        System.out.println("\n 1 ----> Add Member");
        System.out.println(" 2 ----> Delete Member");
        System.out.println(" 3 ----> Edit Member");
        System.out.println(" 4 ----> Show Member");
        System.out.println(" 5 ----> Exit");
        System.out.print("----> Please choose what you want from the menu: ");
    }
}