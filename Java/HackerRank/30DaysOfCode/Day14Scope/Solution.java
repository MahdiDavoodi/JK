package mahdi.davoodi;

import java.util.Scanner;

/*
 * (Solved by myself.)
 * Link --->  https://www.hackerrank.com/challenges/30-scope/problem
 * */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        String[] inputArray = input.split(" ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        int max = Integer.MIN_VALUE, temp;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                temp = Math.abs(array[i] - array[j]);
                if (temp > max) max = temp;
            }
        }

        System.out.println(max);
    }
}