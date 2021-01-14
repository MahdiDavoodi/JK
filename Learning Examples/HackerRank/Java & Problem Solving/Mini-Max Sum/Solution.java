import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void miniMaxSum(int[] inputArray) {
        long maxSum = 0, minSum = 0;
        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length - 1; i++) {
            minSum += inputArray[i];
        }
        for (int i = inputArray.length - 1; i >= 1; i--) {
            maxSum += inputArray[i];
        }
        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
