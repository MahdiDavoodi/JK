/*
 * Write binary search.
 * It will work on a sorted array.
 * */
public class MyBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("----> We have \"7\"  in our array: " + binarySearch(array, 0, array.length - 1, 7));
    }

    protected static boolean binarySearch(int[] array, int lowIndex, int highIndex, int item) {
        if (lowIndex > highIndex) return false; // It's not in our array.
        else {
            int midIndex = (lowIndex + highIndex) / 2;
            if (item == array[midIndex]) return true;
            else if (item > array[midIndex]) return binarySearch(array, midIndex + 1, highIndex, item);
            else return binarySearch(array, lowIndex, midIndex - 1, item);
        }
    }
}
