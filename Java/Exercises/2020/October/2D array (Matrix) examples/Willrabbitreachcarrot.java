import java.util.concurrent.ThreadLocalRandom;

public class Willrabbitreachcarrot {

    public static int[][] array = new int[10][10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
                if (randomNumber >= 8) array[i][j] = 1;
                else array[i][j] = 0;
            }
        }
        array[0][0] = 3;
        array[9][9] = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (j < 9) {

                    if (array[i][j] == 3 && array[i][j + 1] == 0) array[i][j + 1] = 3;

                }
                if (i < 9) {

                    if (array[i][j] == 3 && array[i + 1][j] == 0) array[i + 1][j] = 3;

                }

            }
        }

        if (array[9][9] == 3) System.out.println("-----> Rabbit will reach the carrot :)");
         else System.out.println("-----> Rabbit wont reach the carrot :(");
    }
}
