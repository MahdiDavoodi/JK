package mahdi.davoodi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> phonebook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine().trim();
            Integer phoneNumber = scanner.nextInt();
            phonebook.put(name, phoneNumber);
            scanner.nextLine();
        }
        while (scanner.hasNext()) {
            String check = scanner.nextLine();
            if (phonebook.containsKey(check))
                System.out.println(check + "=" + phonebook.get(check));
            else
                System.out.println("Not found");
        }
    }
}
/*
 * This is a challenge from HackerRank. Suitable for JDK15.
 * Link --> https://www.hackerrank.com/challenges/phone-book/problem
 * Concepts: Maps, Scanner.hasNext();
 * */