/*
 * Revert an array with recursion!
 * */
public class ReversingArrayRecursion {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        reversingArray(array, 0, array.length - 1);
        for (int n :
                array) {
            System.out.print(n + ", ");
        }
    }

    protected static void reversingArray(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int temp = array[lowIndex];
            array[lowIndex] = array[highIndex];
            array[highIndex] = temp;

            reversingArray(array, lowIndex + 1, highIndex - 1);
        }
    }
}
