package ir.blog.mahdidavoodi;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Account {

    public  String userInFirstName, inEmail, email, password, name, currentUsername;
    public  long inPassword;
    public  final File accountsData = new File("Accounts.txt");


    public boolean createAccount() throws IOException {

        System.out.println(Main.ANSI_BLUE + "-----> What's your name?" + Main.ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("---> ");
            userInFirstName = scanner.nextLine().trim();
            int counter = 0;
            for (int i = 0; i < userInFirstName.length() - 1; i++)
                if (Character.isLetter(userInFirstName.charAt(i))) counter++;
            if (counter == userInFirstName.length() - 1) break;
            else
                System.out.println(Main.ANSI_BLUE + "-----> Please input your REAL NAME (without numbers and symbols)!" + Main.ANSI_RESET);

        }
        System.out.println(Main.ANSI_BLUE + "-----> " + userInFirstName + "! " + "What a beautiful name." + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> Now,enter your email address. It will be your username." + Main.ANSI_RESET);
        while (true) {

            System.out.print("---> Username: ");
            inEmail = scanner.nextLine().trim();
            if (emailChecker(inEmail)) {

                if (accountsData.exists()) {
                    int i = 0;
                    BufferedReader reader = new BufferedReader(new FileReader(accountsData));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(" ");
                        if (parts[0].equalsIgnoreCase(inEmail)) {
                            i++;
                        }
                    }
                    if (i == 0) break;
                    else
                        System.out.println(Main.ANSI_RED + "-----> Email has been used by another person (It might be you!)." + Main.ANSI_RESET);

                } else break;

            } else System.out.println(Main.ANSI_RED + "-----> Email is invalid." + Main.ANSI_RESET);

        }
        System.out.println(Main.ANSI_BLUE + "-----> Ok " + userInFirstName + ". Now create a strong password." + Main.ANSI_RESET);
        while (true) {

            System.out.print("---> Password: ");
            String passTemp1 = scanner.nextLine().trim();
            if (highSecurityPassword(passTemp1)) {

                System.out.print(Main.ANSI_BLUE + "---> Confirm Password: " + Main.ANSI_RESET);
                String passTemp2 = scanner.nextLine().trim();
                if (passTemp2.equals(passTemp1)) {
                    inPassword = passwordHash(passTemp2);
                    break;
                } else System.out.print(Main.ANSI_RED + "-----> Password did Not match!" + Main.ANSI_RESET);

            } else System.out.print(Main.ANSI_RED + "-----> Your Password is weak!" + Main.ANSI_RESET);

        }

        CAPTCHA();

        saveData(userInFirstName, inEmail, inPassword);

        System.out.println(Main.ANSI_BLUE + "-----> Your account created! Welcome " + userInFirstName + ":)" + Main.ANSI_RESET);
        currentUsername = inEmail;
        return true;
    }

    public boolean login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (accountsData.exists()) {

            System.out.println(Main.ANSI_BLUE + "-----> Please input your username and password." + Main.ANSI_RESET);
            System.out.print("---> Username: ");
            email = scanner.nextLine().trim();
            System.out.print("---> Password: ");
            password = scanner.nextLine().trim();
            if (correctInformation(email, password)) {
                System.out.println(Main.ANSI_BLUE + "-----> Welcome " + name + "!" + Main.ANSI_RESET);
                currentUsername = email;
                return true;
            } else {
                System.out.println(Main.ANSI_RED + "-----> The password or username is not correct." + Main.ANSI_RESET);
                return false;
            }
        } else System.out.println(Main.ANSI_RED + "--------> There is no saved data!" + Main.ANSI_RESET);
        return false;
    }

    public void CAPTCHA() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String[] operators = {" + ", " - ", " × "};
            int randomNumber = ThreadLocalRandom.current().nextInt(0, 3);
            int randomNumberOne = ThreadLocalRandom.current().nextInt(0, 11);
            int randomNumberTwo = ThreadLocalRandom.current().nextInt(0, 11);
            int result = 0;
            if (randomNumber == 0) result = randomNumberOne + randomNumberTwo;
            else if (randomNumber == 1) result = randomNumberOne - randomNumberTwo;
            else if (randomNumber == 2) result = randomNumberOne * randomNumberTwo;
            System.out.println(Main.ANSI_BLUE
                    + "-----> What is the answer of "
                    + randomNumberOne
                    + operators[randomNumber]
                    + randomNumberTwo
                    + " ?"
                    + Main.ANSI_RESET);
            System.out.print("--->");
            int userAnswer = scanner.nextInt();
            if (result == userAnswer) break;

        }
    }

    public  long passwordHash(String passwordTemp) {
        long passwordSign = 1;
        for (int i = 0; i < passwordTemp.length(); i++) {
            passwordSign = (passwordSign * 255 + passwordTemp.charAt(i)) % 1000000;
        }
        return passwordSign;
    }

    public  boolean highSecurityPassword(String passTemp) {

        int securityLevel = 0;
        if (passTemp.length() >= 3 && passTemp.length() < 20) {

            boolean hasLowercaseLetter = false, hasUppercaseLetter = false, hasDigit = false, hasOtherSymbols = false, hasSpaces = false;
            for (int i = 0; i < passTemp.length(); i++) {

                if (Character.isLetter(passTemp.charAt(i))) {
                    char ch = passTemp.charAt(i);
                    if (ch >= 'A' && ch <= 'Z') hasUppercaseLetter = true;
                    else if (ch >= 'a' && ch <= 'z') hasLowercaseLetter = true;

                } else if (Character.isLetter(passTemp.charAt(i))) hasDigit = true;
                else if (passTemp.charAt(i) == ' ') hasSpaces = true;
                else hasOtherSymbols = true;
            }
            if (hasDigit) securityLevel = securityLevel + 4;
            if (hasLowercaseLetter) securityLevel = securityLevel + 3;
            if (hasUppercaseLetter) securityLevel = securityLevel + 4;
            if (hasSpaces) securityLevel = securityLevel + 3;
            if (hasOtherSymbols) securityLevel = securityLevel + 4;
            if (passTemp.length() >= 6) securityLevel = securityLevel + 6;

        }
        return securityLevel >= 10;
    }

    public  boolean emailChecker(String inEmail) {

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return inEmail.matches(regex);
    }

    public  boolean correctInformation(String email, String password) throws IOException {

        if (accountsData.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(accountsData));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equalsIgnoreCase(email)) {
                    long inputPassword = passwordHash(password);
                    long savedPassword = Long.parseLong(parts[1]);
                    if (savedPassword == inputPassword) {
                        name = parts[2];
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public  void saveData(String userInFirstName, String inEmail, long inPassword) throws IOException {

        if (accountsData.exists()) {

            BufferedReader reader = new BufferedReader(new FileReader(accountsData));
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedDataTemp.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.close();
            reader.close();

            reader = new BufferedReader(new FileReader("savedDataTemp.txt"));
            writer = new BufferedWriter(new FileWriter("Accounts.txt"));
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.write(inEmail + " ");
            writer.write(inPassword + " ");
            writer.write(userInFirstName + "\n");
            writer.close();
            reader.close();

            File savedDataTemp = new File("savedDataTemp.txt");
            if (savedDataTemp.exists()) savedDataTemp.delete();


        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Accounts.txt"));
            writer.write(inEmail + " ");
            writer.write(inPassword + " ");
            writer.write(userInFirstName + "\n");
            writer.close();

        }

    }
}
