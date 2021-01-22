import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        boolean theyAreEqual = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt((input.length() - 1) - i)) theyAreEqual = false;
        }
        if (theyAreEqual) System.out.println("Yes");
        else System.out.println("No");
    }
}
