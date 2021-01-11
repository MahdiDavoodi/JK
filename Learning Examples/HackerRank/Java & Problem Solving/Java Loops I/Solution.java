import java.util.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        scanner.close();
    }
}
