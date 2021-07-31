import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int maxNumber = 0;
        String[] strings = Integer.toBinaryString(number).split("0");

        for (String string :
                strings) {
            if (string.length() > maxNumber) maxNumber = string.length();
        }
        System.out.println(maxNumber);
    }
}
