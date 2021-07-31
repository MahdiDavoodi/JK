import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        String firstLetterOfA = A.substring(0,1),firstLetterOfB = B.substring(0,1);
        String resultA = firstLetterOfA.toUpperCase() + A.substring(1);
        String resultB = firstLetterOfB.toUpperCase() + B.substring(1);

        System.out.println(A.length()+B.length());
        if (A.charAt(0) > B.charAt(0)) System.out.println("Yes");
        else System.out.println("No");
        System.out.println(resultA + " " + resultB);

    }
}
