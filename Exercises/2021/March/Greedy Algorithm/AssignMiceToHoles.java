package ir.blog.mahdidavoodi;

import java.util.Arrays;

/*
 * Greedy Algorithm examples solved by myself!
 * N Mouse / N Holes - Each hole can accommodate only 1 mouse.
 * Minimum time to assign all mice to holes!
 * Source: https://www.geeksforgeeks.org/assign-mice-holes/
 * */
public class AssignMiceToHoles {
    public static void main(String[] args) {
        int[] mice = {4, -4, 2};
        int[] holes = {4, 0, 5};
        if (mice.length == holes.length)
            System.out.println("----> Last mouse gets inside the last hole in: " + minTime(mice, holes));
    }

    static int minTime(int[] mice, int[] holes) {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int minTimeForAll = 0; // Max of all mice.

        for (int i = 0; i < mice.length; i++) {
            if (minTimeForAll < Math.abs(mice[i] - holes[i]))
                minTimeForAll = Math.abs(mice[i] - holes[i]);
        }
        return minTimeForAll;
    }
}
