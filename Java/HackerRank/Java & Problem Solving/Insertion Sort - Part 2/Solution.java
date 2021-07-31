import java.util.*;

public class Solution {

    static void insertionSort1(int n, int[] array) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int currentNumber = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = currentNumber;
                    break;
                }
            }
            printArray(array);
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

        int[] array = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            array[i] = arrItem;
        }

        insertionSort1(n, array);

        scanner.close();
    }
}
