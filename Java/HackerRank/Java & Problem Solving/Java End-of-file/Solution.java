import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            System.out.println(counter + " " + s);
            counter++;
        }
    }
}
