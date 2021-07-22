package ir.blog.mahdidavoodi;

import java.util.Arrays;

class RodCut {

    static int dynamicMemoizedCut(int[] prices, int n, int[] data) {
        if (data[n] >= 0)
            return data[n];
        int max;
        if (n == 0) max = 0;
        else max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, prices[i] + dynamicMemoizedCut(prices, n - i - 1, data));
        }
        data[n] = max;
        return max;
    }

    static int dynamicBottomUpCut(int[] prices, int n) {
        int[] data = new int[n + 1];
        data[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + data[i - j - 1]);
            }
            data[i] = max;
        }

        return data[n];
    }

    static int normalCut(int[] price, int n) {
        if (n <= 0)
            return 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, price[i] + normalCut(price, n - i - 1));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 10, 16, 18, 20, 34, 34, 40};
        int size = array.length;
        System.out.println("----> Max price Normal recursion: " + normalCut(array, size));

        System.out.println("----> Max price Bottom up: " + dynamicBottomUpCut(array, size));
        int[] data = new int[size + 1];
        Arrays.fill(data, Integer.MIN_VALUE);
        System.out.println("----> Max price memoized: " + dynamicMemoizedCut(array, size, data));

    }
}