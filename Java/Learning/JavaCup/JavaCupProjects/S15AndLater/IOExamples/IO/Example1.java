package ir.blog.mahdidavoodi;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Example1 {
    /*
     * A simple example for copy a text file.
     * We used try with resources for this example.
     * So we don't need to close the scanner and formatter.
     * They will close automatically.
     *  */
    public static void main(String[] args) {
        File file = new File("Hello.txt");
        try (Scanner scanner = new Scanner(file);
             Formatter formatter = new Formatter("SecondHello.txt")) {
            while (scanner.hasNextLine()) {
                formatter.format("%s\n", scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
