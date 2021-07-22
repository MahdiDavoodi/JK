package ir.blog.mahdidavoodi;

public class WhichOneIsRepeated {
    public static void main(String[] args) {
        int[] array = new int[]{
                1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        };
        System.out.println("---> The Number is: " + finder(array, 0, array.length - 1));

    }

    private static int finder(int[] array, int firstIndex, int lastIndex) {

        int midIndex = (firstIndex + lastIndex) / 2;
        if (firstIndex + 1 == lastIndex) midIndex = lastIndex;
        if (array[midIndex] == midIndex) {
            if (array[midIndex - 1] == midIndex) return midIndex;
            return finder(array, firstIndex, midIndex);
        } else return finder(array, midIndex, lastIndex);
    }

}
