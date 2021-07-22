package ir.blog.mahdidavoodi;

class GolombSequence {
    /*
     * Normal recursive version.
     * */
    public static int golomb(int n) {
        if (n == 1) return 1;
        return 1 + golomb(n - golomb(golomb(n - 1)));
    }

    public static void printGolomb(int n) {
        for (int i = 1; i <= n; i++) System.out.print(golomb(i) + " ");
    }

    /*
     * Dynamic version.
     * Just like the recursive method's formula, but this time without recursion! 🙃
     * Data[] will help us to store the previous values to use for next values.
     * */
    public static void dynamicPrintGolomb(int n) {
        int[] data = new int[n + 1];
        data[1] = 1;
        System.out.print(data[1] + " ");

        for (int i = 2; i <= n; i++) {
            data[i] = 1 + data[i - data[data[i - 1]]];
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        printGolomb(10);
        System.out.println();
        dynamicPrintGolomb(50);
    }
}