import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int theNumberOfCases = scanner.nextInt();
        String string, evenChars, oddChars;
        for (int i = 0; i < theNumberOfCases; i++) {
            evenChars = "";
            oddChars = "";
            string = scanner.next().trim();
            evenChars += string.charAt(0); // Assume zero is an even number!
            for (int j = 1; j < string.length(); j++) {
                if (j % 2 == 0) evenChars += string.charAt(j);
                else oddChars += string.charAt(j);
            }
            System.out.println(evenChars + " " + oddChars);
        }
    }
}
