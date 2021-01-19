import java.util.*;


public class Solution {

    static int factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(factorial(n));
        scanner.close();
    }
}
