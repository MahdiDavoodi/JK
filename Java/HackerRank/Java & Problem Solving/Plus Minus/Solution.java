import java.util.*;

public class Solution {

    static void plusMinus(int[] arr) {
        float positiveNumbers = 0, zeroNumbers = 0, negativeNumbers = 0, totalNumbers = arr.length;
        for (int number :
                arr) {
            if (number > 0) positiveNumbers++;
            else if (number == 0) zeroNumbers++;
            else negativeNumbers++;
        }
        System.out.format("%f\n", positiveNumbers / totalNumbers);
        System.out.format("%f\n", negativeNumbers / totalNumbers);
        System.out.format("%f\n", zeroNumbers / totalNumbers);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
