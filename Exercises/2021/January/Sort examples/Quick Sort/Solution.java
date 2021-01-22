import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        int[] inputArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            inputArray[i] = Integer.parseInt(input[i]);
        }

        QuickSort quickSort = new QuickSort(inputArray);
        System.out.print("---> UnSorted: ");
        quickSort.display();
        quickSort.sort(0, inputArray.length - 1);
        System.out.println();
        System.out.print("---> Sorted: ");
        quickSort.display();
    }
}

class QuickSort {
    private final int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void sort(int start, int end) {
        int arrayMiddle = (start + end) / 2;
        int left = start;
        int right = end;
        int pivot = array[arrayMiddle];
        while (left <= right) {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right)
            sort(start, right);
        if (left < end)
            sort(left, end);
    }

    public void display() {
        for (int j : array) {
            System.out.print(" " + j);
        }
    }
}
