import java.util.*;

class Solution {
    public static void main(String[] argh) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int c = a;
            for (int j = 0; j < n; j++) {
                c += Math.pow(2, j) * b;
                System.out.print(c + " ");
            }
            System.out.print("\n");
        }
        scanner.close();
    }
}
