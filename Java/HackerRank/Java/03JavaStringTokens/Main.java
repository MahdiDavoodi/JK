package mahdi.davoodi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] all;
        if (input.isEmpty())
            all = new String[0];
        else
            all = input.split("[ !,?._'@]+");
        System.out.println(all.length);
        for (String s :
                all) {
            System.out.println(s);
        }
    }
}
/*
 * This is an exercise from HackerRank.
 * Link ---> https://www.hackerrank.com/challenges/java-string-tokens/problem
 * */