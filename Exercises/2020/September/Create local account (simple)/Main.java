import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static String userInFirstName, inEmail, email, password, name;
    public static long inPassword;
    public static Scanner scanner = new Scanner(System.in);
    public static File savedData = new File("/home/mahdi/IdeaProjects/MahdiDavoodiAccount/savedData.txt");


    public static void main(String[] args) throws IOException {

        System.out.println("----> Hey! Choose what you want to do:");
        while (true) {

            System.out.println("-------> Login or Create an account [L/C]?");
            System.out.print("====> ");
            String loginOrCreateAnAccount = scanner.nextLine().trim();
            if (loginOrCreateAnAccount.equalsIgnoreCase("L")) {
                loginMethod();
                break;
            } else if (loginOrCreateAnAccount.equalsIgnoreCase("C")) {
                createAnAccountMethod();
                break;
            }

        }
    }


    public static void createAnAccountMethod() throws IOException {

        System.out.println("-------> So, You gonna create your account. Great!");
        System.out.println("-------> Now, what's your name?");

        while (true) {

            System.out.print("====> ");
            userInFirstName = scanner.nextLine().trim();
            int counter = 0;
            for (int i = 0; i < userInFirstName.length() - 1; i++) {
                if (Character.isLetter(userInFirstName.charAt(i))) counter++;
            }
            if (counter == userInFirstName.length() - 1) break;
            else System.out.println("-------> Please input your REAL NAME (without numbers and symbols)!");

        }
        System.out.println("-------> " + userInFirstName + "! " + "What a beautiful name.");
        System.out.println("-------> Now,enter your email address. It will be your username.");
        while (true) {

            System.out.print("====> Username: ");
            inEmail = scanner.nextLine().trim();
            if (emailChecker(inEmail)) {

                if (savedData.exists()) {
                    int i = 0;
                    BufferedReader reader = new BufferedReader(new FileReader(savedData));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(" ");
                        if (parts[0].equalsIgnoreCase(inEmail)) {
                            i++;
                        }
                    }
                    if (i == 0) break;
                    else System.out.println("-------> Email has been used by another person (It might be you!).");

                } else break;

            } else System.out.println("-------> Email is invalid.");

        }
        System.out.println("-------> Ok " + userInFirstName + ". Now create a strong password.");
        while (true) {

            System.out.print("====> Password: ");
            String passTemp1 = scanner.nextLine().trim();
            if (highSecurityPassword(passTemp1)) {

                System.out.print("====> Confirm Password: ");
                String passTemp2 = scanner.nextLine().trim();
                if (passTemp2.equals(passTemp1)) {
                    inPassword = passwordHash(passTemp2);
                    break;
                } else System.out.println("-------> Password did NOT match!");

            } else System.out.println("-------> Your password is weak!");

        }

        CAPTCHA();

        saveData(userInFirstName, inEmail, inPassword);

        System.out.println("Your account created! Welcome " + userInFirstName + ":)");
    }


    private static void CAPTCHA() {
        while (true) {
            int randomNumberOne = ThreadLocalRandom.current().nextInt(0, 11);
            int randomNumberTwo = ThreadLocalRandom.current().nextInt(0, 11);
            int sum = randomNumberOne + randomNumberTwo;
            System.out.println("-------> What is the answer of " + randomNumberOne + " + " + randomNumberTwo + " ?");
            System.out.print("====> ");
            int userAnswer = scanner.nextInt();
            if (sum == userAnswer) break;
        }
    }


    public static void saveData(String userInFirstName, String inEmail, long inPassword) throws IOException {

        if (savedData.exists()) {

            BufferedReader reader = new BufferedReader(new FileReader(savedData));
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedDataTemp.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.close();
            reader.close();

            reader = new BufferedReader(new FileReader("savedDataTemp.txt"));
            writer = new BufferedWriter(new FileWriter("savedData.txt"));
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.write(inEmail + " ");
            writer.write(inPassword + " ");
            writer.write(userInFirstName + "\n");
            writer.close();
            reader.close();

            File savedDataTemp = new File("/home/mahdi/IdeaProjects/MahdiDavoodiAccount/savedDataTemp.txt");
            if (savedDataTemp.exists()) savedDataTemp.delete();


        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedData.txt"));
            writer.write(inEmail + " ");
            writer.write(inPassword + " ");
            writer.write(userInFirstName + "\n");
            writer.close();

        }

    }


    public static long passwordHash(String passwordTemp) {
        long passwordSign = 1;
        for (int i = 0; i < passwordTemp.length(); i++) {
            passwordSign = (passwordSign * 255 + passwordTemp.charAt(i)) % 1000000;
        }
        return passwordSign;
    }


    public static boolean highSecurityPassword(String passTemp) {

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
            if (hasDigit) securityLevel = securityLevel + 3;
            if (hasLowercaseLetter) securityLevel = securityLevel + 3;
            if (hasUppercaseLetter) securityLevel = securityLevel + 3;
            if (hasSpaces) securityLevel = securityLevel + 3;
            if (hasOtherSymbols) securityLevel = securityLevel + 4;
            if (passTemp.length() >= 6) securityLevel = securityLevel + 6;

            if (securityLevel >= 10) return true;
        }

        return false;
    }


    public static boolean emailChecker(String inEmail) {

        int lastIndexOfAt_sign = inEmail.lastIndexOf('@');
        int firstIndexOfAt_sign = inEmail.indexOf('@');
        char lastCharacterOfEmail = inEmail.charAt(inEmail.length() - 1);
        int lastIndexOfDot = inEmail.lastIndexOf('.');
        char characterAfterAt_sign = inEmail.charAt(firstIndexOfAt_sign + 1);
        char characterBeforeAt_sign = inEmail.charAt(firstIndexOfAt_sign - 1);

        int spaceChecker = 0;
        int dotChecker = 0;
        int hyphenChecker = 0;

        // An email address must contains @
        if (lastIndexOfAt_sign > -1 && firstIndexOfAt_sign > -1) {

            // Only one @ sign is allowed.
            if (lastIndexOfAt_sign == firstIndexOfAt_sign) {

                // An email address must not accept white spaces
                for (int i = 0; i < inEmail.length() - 1; i++) {
                    if (inEmail.charAt(i) == ' ') {
                        spaceChecker = 1;
                        break;
                    }
                }
                if (spaceChecker == 0) {

                    // An email address must not end in a character other than a letter or a number
                    if ((Character.isLetter(lastCharacterOfEmail)) || (Character.isDigit(lastCharacterOfEmail))) {

                        // There must be at least one dot after the @
                        if (lastIndexOfDot > lastIndexOfAt_sign) {

                            // There must be at most one dot/hyphen before the @
                            for (int i = 0; i < firstIndexOfAt_sign; i++) {
                                if (inEmail.charAt(i) == '.') dotChecker++;
                                else if (inEmail.charAt(i) == '-') hyphenChecker++;
                            }
                            if (dotChecker <= 1 && hyphenChecker <= 1) {

                                // In the domain , between @ and the dot, the characters that are next to the @ and the dot must be a letter or number
                                if ((Character.isDigit(characterAfterAt_sign)) || (Character.isLetter(characterAfterAt_sign))) {

                                    if ((Character.isDigit(characterBeforeAt_sign)) || (Character.isLetter(characterBeforeAt_sign))) {

                                        String[] parts = inEmail.split("@");

                                        if (!isValidWordInEmail(parts[0])) {
                                            return false;
                                        }
                                        String[] domain = parts[1].split(".");
                                        // domain[0] == w1  domain[1] == w2
                                        for (int i = 0; i < domain.length; i++) {
                                            if (!isValidWordInEmail(domain[i])) {
                                                return false;
                                            }
                                        }
                                        return true;

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }
        return false;
    }


    private static boolean isValidWordInEmail(String word) {
        if (word.length() == 0) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i)) &&
                    !Character.isLetter(word.charAt(i)) &&
                    word.charAt(i) != '-'
            ) return false;
        }
        return true;
    }


    public static void loginMethod() throws IOException {

        if (savedData.exists()) {

            System.out.println("-------> Please input your username and your password.");
            System.out.print("====> Username: ");
            email = scanner.nextLine().trim();
            System.out.print("====> Password: ");
            password = scanner.nextLine().trim();
            if (correctInformation(email, password)) System.out.println("Welcome " + name + "!");
            else {
                System.out.println("-------> The password or username is not correct.");
                while (true) {

                    System.out.println("-------> Do you want to Try again or Exit [T/E]?");
                    System.out.print("====> ");
                    String loginOrCreateAnAccount = scanner.nextLine().trim();
                    if (loginOrCreateAnAccount.equalsIgnoreCase("T")) {
                        loginMethod();
                        break;
                    } else if (loginOrCreateAnAccount.equalsIgnoreCase("E")) {
                        System.out.println("");
                        return;
                    }

                }
            }
        } else System.out.println(ANSI_RED + "--------> There is no saved data!" + ANSI_RESET);

    }


    public static boolean correctInformation(String email, String password) throws IOException {

        if (savedData.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(savedData));
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
    
}
