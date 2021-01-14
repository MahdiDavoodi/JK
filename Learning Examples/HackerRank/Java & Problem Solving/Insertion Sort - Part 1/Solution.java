import java.util.*;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        int theNumber = arr[n - 1];
        int i;
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > theNumber) {
                arr[i + 1] = arr[i];
            } else {
                arr[i + 1] = theNumber;
                printArray(arr);
                break;
            }
            printArray(arr);
        }
        if (i + 1 == 0) {
            arr[i + 1] = theNumber;
            printArray(arr);
        }
    }

    static void printArray(int[] array) {
        for (int number :
                array) {
            System.out.print(number + " ");
        }
        System.out.print("\n");
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
