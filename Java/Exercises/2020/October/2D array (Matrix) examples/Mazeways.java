import java.util.concurrent.ThreadLocalRandom;

public class Mazeways {

    public static int[][] array = new int[10][10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
                if (randomNumber >= 8) array[i][j] = 1;
                else array[i][j] = 0;
            }
        }
        array[0][0] = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j] + "  ");
                if (j == 9) System.out.println(" ");
            }
        }
        int i = 0, j = 0;
        int ways = mazeWays(array ,i, j);
        System.out.println("------> We have " + ways + " ways !");
    }

    private static int mazeWays(int[][] array, int i, int j) {
        if(i<0 || i>9) return 0;
        if(j<0 || j>9) return 0;
        if(i==9 && j==9) return 1;
        if(array[i][j] == 1) return 0;
        return mazeWays(array,  i+ 1, j) + mazeWays(array, i, j + 1);
    }
}
