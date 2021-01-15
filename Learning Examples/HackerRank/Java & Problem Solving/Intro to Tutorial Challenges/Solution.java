import java.io.*;
import java.util.*;


public class Solution {

    static int introTutorial(int V, int[] arr) {
        return Arrays.binarySearch(arr, V);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int V = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        scanner.nextLine();
        String[] arrItems = scanner.nextLine().trim().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        scanner.close();
        System.out.println(introTutorial(V, arr));

    }
}
