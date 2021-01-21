import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        mergeSort(array);
        for (int j : array) System.out.print(j + " ");
    }

    private static void mergeSort(int[] array) {
        if (array.length < 2) return;
        int arrayMiddle = array.length / 2;
        int[] subArrayOne = new int[arrayMiddle], subArrayTwo = new int[array.length - arrayMiddle];

        System.arraycopy(array, 0, subArrayOne, 0, arrayMiddle);
        if (array.length - arrayMiddle >= 0)
            System.arraycopy(array, arrayMiddle, subArrayTwo, 0, array.length - arrayMiddle);
        mergeSort(subArrayOne);
        mergeSort(subArrayTwo);

        merge(array, subArrayOne, subArrayTwo, arrayMiddle, array.length - arrayMiddle);
    }

    public static void merge(int[] array, int[] subArrayOne, int[] subArrayTwo, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (subArrayOne[i] <= subArrayTwo[j]) array[k++] = subArrayOne[i++];
            else array[k++] = subArrayTwo[j++];

        }
        while (i < left) array[k++] = subArrayOne[i++];
        while (j < right) array[k++] = subArrayTwo[j++];
    }
}
