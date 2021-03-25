package ir.blog.mahdidavoodi;

import java.util.Scanner;

/*
 * Longest Common Subsequence!
 * Thanks to:
 * ---> https://www.youtube.com/watch?v=ASoaQq66foQ
 * ---> https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class LCS {

    static int lcs(char[] X, char[] Y, int xLength, int yLength) {
        int[][] DPTable = new int[xLength + 1][yLength + 1];

        for (int x = 0; x <= xLength; x++) {
            for (int y = 0; y <= yLength; y++) {
                if (x == 0 || y == 0)
                    DPTable[x][y] = 0;
                else if (X[x - 1] == Y[y - 1])
                    DPTable[x][y] = DPTable[x - 1][y - 1] + 1;
                else
                    DPTable[x][y] = Math.max(DPTable[x - 1][y], DPTable[x][y - 1]);
            }
        }
        return DPTable[xLength][yLength];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1, string2;
        string1 = scanner.nextLine();
        string2 = scanner.nextLine();

        char[] X = string1.toCharArray();
        char[] Y = string2.toCharArray();

        System.out.println("---> LCS: " + lcs(X, Y, X.length, Y.length));
    }
}