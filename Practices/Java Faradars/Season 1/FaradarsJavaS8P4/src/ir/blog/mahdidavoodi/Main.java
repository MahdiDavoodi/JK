package ir.blog.mahdidavoodi;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double[] A = {1, 12, 30, 15, 43, 25, 32, 105};

        double[] B = Arrays.copyOf(A, A.length + 5);   // We can create a copy of first array.

        System.out.println("----> Before Sort:");
        System.out.format("A = %s\n", Arrays.toString(A));

        Arrays.sort(A);                   // We can sort an array just like that :)

        System.out.println("----> After Sort:");
        System.out.format("A = %s\n", Arrays.toString(A));

        double a = 25;
        int index = Arrays.binarySearch(A, a);                 // Find a number in an array. If it is > 0 we have that number in our array.
        System.out.format("----> A[%d] = %f\n", index, a);

        System.out.format("B = %s\n", Arrays.toString(B));   // Just to see second array.
    }
}
