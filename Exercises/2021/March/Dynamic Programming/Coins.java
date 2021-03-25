package ir.blog.mahdidavoodi;

class Coins {
    /*
     * Normal recursive version.
     * Same problems are called again, this problem has Overlapping problems property.
     * */
    static int count(int[] coins, int numberOfCoins, int number) {
        if (number == 0) return 1;

        if (number < 0) return 0;

        if (numberOfCoins <= 0) return 0;

        return count(coins, numberOfCoins - 1, number) +
                count(coins, numberOfCoins, number - coins[numberOfCoins - 1]);
    }

    /*
     * Dynamic version.
     * Time complexity of this function: O((numberOfCoins)n).
     * Space Complexity of this function: O(n).
     * Data[i] will be storing the number of solutions.
     * */
    static long dynamicCount(int[] coins, int numberOfCoins, int number) {
        long[] data = new long[number + 1];
        data[0] = 1;

        for (int i = 0; i < numberOfCoins; i++)
            for (int j = coins[i]; j <= number; j++)
                data[j] += data[j - coins[i]];

        return data[number];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int numberOfCoins = array.length;
        System.out.println("---> " + count(array, numberOfCoins, 4));
        System.out.println("---> " + dynamicCount(array, numberOfCoins, 4));
    }
}
