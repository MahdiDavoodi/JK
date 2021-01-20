import java.util.*;

class Result {
    
    public static int diagonalDifference(int[][] array, int n) {
        int firstDiagonal = 0, secondDiagonal = 0;
        for (int i = 0; i < n; i++) {
            firstDiagonal += array[i][i];
        }
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            secondDiagonal += array[i][j];
            j--;
        }
        return Math.abs(firstDiagonal - secondDiagonal);
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] input;
        int[][] array = new int[number][number];
        for (int i = 0; i < number; i++) {
            input = scanner.nextLine().split(" ");
            for (int j = 0; j < number; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }
        scanner.close();
        System.out.println(Result.diagonalDifference(array, number));
    }
}
