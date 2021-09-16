package mahdi.davoodi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (isAnagrams(scanner.nextLine().trim().toLowerCase(),
                scanner.nextLine().trim().toLowerCase()))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }

    private static boolean isAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        List<Character> list = new ArrayList<>();

        for (Character ch : b.toCharArray())
            list.add(ch);

        for (Character ch : a.toCharArray())
            list.remove(ch);

        return list.size() == 0;
    }
}
/*
 * This is challenge from HackerRank.com
 * Link ---> https://www.hackerrank.com/challenges/java-anagrams/problem
 * This is my solution.
 * */