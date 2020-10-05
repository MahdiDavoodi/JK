import java.util.concurrent.ThreadLocalRandom;

public class Rotate {

    public static int[][] array = new int[10][10];

    public static void main(String[] args) {

        // Fill the array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(10, 100);
                array[i][j] = randomNumber;
            }
        }

        // First print
        System.out.println("-----> At first:");
        printMatrix(array, 10, 10);

        // Rotate 180 degrees
        rotate(array, 10, 10);
    }

    private static void rotate(int[][] array, int i, int j) {
        int temp;
        for (int k = 0; k < i / 2; k++) {
            for (int l = 0; l < j; l++) {
                temp = array[l][(i - 1) - k];
                array[l][(i - 1) - k] = array[l][k];
                array[l][k] = temp;
            }
        }

        for (int k = 0; k < i / 2; k++) {
            for (int l = 0; l < j; l++) {
                temp = array[(i - 1) - k][l];
                array[(i - 1) - k][l] = array[k][l];
                array[k][l] = temp;
            }
        }

        System.out.println("-----> After rotate:");
        printMatrix(array, i, j);
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

}
