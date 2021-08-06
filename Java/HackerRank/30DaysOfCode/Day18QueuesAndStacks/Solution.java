package mahdi.davoodi;

/*
 * (Solved by me.)
 * Link --->  https://www.hackerrank.com/challenges/30-queues-stacks/problem
 * */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String temp;
        for (int i = 0; i < input.length(); i++) {
            temp = String.valueOf(input.charAt(i));
            stack.push(temp);
            queue.add(temp);
        }
        boolean isPalindrome = true;
        for (int i = 0; i < input.length(); i++) {
            if (!stack.pop().equalsIgnoreCase(queue.poll()))
                isPalindrome = false;
        }

        if (isPalindrome) System.out.println("The word, " + input + ", is a palindrome.");
        else System.out.println("The word, " + input + ", is not a palindrome.");
    }
}