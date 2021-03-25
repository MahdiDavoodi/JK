package ir.blog.mahdidavoodi;

import java.util.Scanner;

/*
 * Edit Distance Between 2 Strings (The Levenshtein Distance)
 * Thanks to:
 * ---> https://www.youtube.com/watch?v=MiqoA-yF-0M
 * */
public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();

        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        System.out.println("---> The edit distance between them is: " + editDistance(first, second));
    }

    static int editDistance(char[] first, char[] second) {
        int n = first.length, m = second.length;
        int[][] DPTable = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) DPTable[i][j] = j;
                else if (j == 0) DPTable[i][j] = i;
                else if (first[i - 1] == second[j - 1]) DPTable[i][j] = DPTable[i - 1][j - 1];
                else
                    DPTable[i][j] = 1 + (Math.min(DPTable[i - 1][j - 1], Math.min(DPTable[i - 1][j], DPTable[i][j - 1])));
            }
        }
        return DPTable[n][m];
    }
}
