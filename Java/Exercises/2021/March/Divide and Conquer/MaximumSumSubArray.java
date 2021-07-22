package ir.blog.mahdidavoodi;

// O(n^2)

class MaximumSumSubArray {

    private static int maxSumSubArray(int[] array) {
        int maxSum = -2147483648, temp;

        for (int i = 0; i < array.length - 1; i++) {
            temp = 0;

            for (int j = i; j < array.length; j++) {
                temp += array[j];

                if (temp > maxSum) {
                    maxSum = temp;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {4, -3, 2, 8, -4, 6, -8};
        System.out.println("The Maximum sum is: O(n^2) --> " + maxSumSubArray(array));
    }
}

