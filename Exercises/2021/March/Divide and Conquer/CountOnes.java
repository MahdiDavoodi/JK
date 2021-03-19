package ir.blog.mahdidavoodi;

public class CountOnes {
    public static void main(String[] args) {
        int[] array = new int[]{
                0, 0, 0, 0, 0, 1, 1, 1, 1, 1,
        };
        System.out.println("---> One Numbers: " + oneCounter(array, 0, array.length - 1));

    }

    private static int oneCounter(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex + 1 == lastIndex) {
            int counter = 0;
            if (array[firstIndex] == 1) counter++;
            if (array[lastIndex] == 1) counter++;

            return counter;
        }
        int midIndex = (firstIndex + lastIndex) / 2;
        if (array[midIndex] == 0) return oneCounter(array, midIndex, lastIndex);
        else return (lastIndex - midIndex) + oneCounter(array, firstIndex, midIndex);
    }
}
