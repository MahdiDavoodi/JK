import java.util.*;

class Solution {
    public static void main(String[] argh) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {

            try {
                long number = scanner.nextLong();
                System.out.println(number + " can be fitted in:");
                if (number >= -128 && number <= 127) System.out.println("* byte");
                if (number >= -32_768 && number <= 32_767) System.out.println("* short");
                if (number >= -(Math.pow(2, 31)) && number <= (Math.pow(2, 31) - 1)) System.out.println("* int");
                if (number >= -(Math.pow(2, 63)) && number <= (Math.pow(2, 63) - 1)) System.out.println("* long");

            } catch (Exception e) {
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }

        }
    }
}
