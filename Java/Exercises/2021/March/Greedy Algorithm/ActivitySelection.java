package ir.blog.mahdidavoodi;

import java.util.Scanner;

/*
 * Greedy Algorithm examples solved by myself!
 * */
public class ActivitySelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] startTemp = scanner.nextLine().trim().split(" ");
        String[] finishTemp = scanner.nextLine().trim().split(" ");
        if (startTemp.length == finishTemp.length) {
            int[] start = new int[startTemp.length],
                    finish = new int[finishTemp.length];

            for (int i = 0; i < start.length; i++) {
                start[i] = Integer.parseInt(startTemp[i]);
            }
            for (int i = 0; i < finish.length; i++) {
                finish[i] = Integer.parseInt(finishTemp[i]);
            }
            sort(start, finish);
            System.out.println("---> The maximum activities we can do: " + activityCounter(start, finish));
        }

    }

    static int activityCounter(int[] start, int[] finish) {
        int total = 1;
        int finishLast = finish[0];
        for (int i = 1; i < finish.length; i++) {
            if (start[i] >= finishLast) {
                finishLast = finish[i];
                total++;
            }
        }
        return total;
    }

    static void sort(int[] start, int[] finish) {
        for (int i = 0; i < finish.length; i++) {
            for (int j = i; j > 0; j--) {
                if (finish[j] < finish[j - 1]) {
                    int startTemp = start[j],
                            finishTemp = finish[j];
                    start[j] = start[j - 1];
                    finish[j] = finish[j - 1];
                    start[j - 1] = startTemp;
                    finish[j - 1] = finishTemp;
                }
            }
        }
    }
}