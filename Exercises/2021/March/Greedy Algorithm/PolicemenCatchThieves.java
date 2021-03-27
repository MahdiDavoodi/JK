package ir.blog.mahdidavoodi;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Greedy Algorithm examples solved by myself!
 * */
public class PolicemenCatchThieves {
    public static void main(String[] args) {
        char[] array = {'P', 'T', 'P', 'T', 'T', 'P'};
        int policeRange = 3;
        System.out.println("---> " + maxThievesCaught(array, policeRange) + " thieves can be caught!");
    }

    static int maxThievesCaught(char[] array, int policeRange) {
        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'T') {
                if (queue.size() == policeRange) queue.remove();
                queue.add('T');
            } else {
                if (queue.size() == 0 && i != array.length - 1 && i != 0) {
                    for (int j = 1; j == policeRange; j++) {
                        if (array[i + j] == 'T') count++;
                        i++;
                    }
                } else if (i == 0) {
                    for (int j = 1; j <= policeRange; j++) {
                        if (array[i + j] == 'T') count++;
                        i++;
                    }
                } else {
                    count += queue.size();
                    queue.clear();
                }
            }
        }
        return count;
    }
}