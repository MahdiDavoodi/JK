package mahdi.davoodi;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        scanner.nextLine();
        ArrayList<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < lines; i++)
            matrix.add(Arrays.stream(scanner.nextLine().trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++)
            try {
                System.out.println(matrix.get(scanner.nextInt() - 1).get(scanner.nextInt()));
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("ERROR!");
            }
    }
}
/*
 * This is a challenge from HackerRank.
 * Link --> https://www.hackerrank.com/challenges/java-arraylist/problem
 * */