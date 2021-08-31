package mahdi.davoodi;
/*
 * (Solved by me.)
 * 30 Days of code - HackerRank - Day 29: Bitwise AND
 * Link --->  https://www.hackerrank.com/challenges/30-bitwise-and/problem
 * */

import java.io.*;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int count = Integer.parseInt(firstMultipleInput[0]);

                int lim = Integer.parseInt(firstMultipleInput[1]);

                int res = Result.bitwiseAnd(count, lim);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {
    public static int bitwiseAnd(int N, int K) {
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = N; j > i; j--) {
                temp = i & j;
                if (temp > max && temp < K)
                    max = temp;
            }
        }
        return max;
    }
}