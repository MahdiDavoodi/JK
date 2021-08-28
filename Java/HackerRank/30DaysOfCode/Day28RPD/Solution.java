package mahdi.davoodi;
/*
 * (Solved by me.)
 * 30 Days of code - HackerRank - Day 28: RegEx, Patterns, and Intro to Databases
 * Link --->  https://www.hackerrank.com/challenges/30-regex-patterns/problem
 * */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MySillyDatabase database = new MySillyDatabase();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().trim();
            char key = input.charAt(0);
            database.add(key, input);
        }
        scanner.close();
        database.printMailNames();
    }
}

class MySillyDatabase {
    private static Map<Character, LinkedList<String>> database;

    MySillyDatabase() {
        database = new HashMap<>();
        initializeDatabase();
    }

    private void initializeDatabase() {
        for (int i = 97; i < 123; i++) {
            database.put((char) i, new LinkedList<>());
        }
    }

    public void add(Character key, String input) {
        database.get(key).add(input);
    }

    public void printMailNames() {
        for (int i = 97; i < 123; i++) {
            LinkedList<String> list = database.get((char) i);
            Collections.sort(list);
            for (String s :
                    list) {
                if (s.contains("@gmail.com"))
                    System.out.println(s.split(" ")[0]);
            }
        }
    }
}