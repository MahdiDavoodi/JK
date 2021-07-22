import java.util.concurrent.ThreadLocalRandom;

public class Islandcounter {

    public static int[][] array = new int[10][10];

    public static void main(String[] args) {
        
        int color = 2;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
                if (randomNumber >= 3) array[i][j] = 1;
                else array[i][j] = 0;
            }
        }
        printMatrix(array, 10, 10);
    
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][j] == 1) {
                    colorLand(array, i, j, color);
                    color++;
                }
            }
        }
        
        //printMatrix(array, 10, 10);
        color--;
        System.out.println("------> We have " + color + " islands !");
      
    }

    private static void printMatrix(int[][] array, int N, int M) {
        System.out.println("Matrix:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf(" %2d ", array[i][j]);
            }
            System.out.println(" ");
        }

    }

    private static void colorLand(int[][] array, int i, int j, int color) {
        if (i < 0 || i > 9) return;
        if (j < 0 || j > 9) return;
        if (array[i][j] != 1) return;
        if (array[i][j] == 1) array[i][j] = color;

        colorLand(array, i - 1, j, color);
        colorLand(array, i + 1, j, color);
        colorLand(array, i, j - 1, color);
        colorLand(array, i, j + 1, color);
    }

}
