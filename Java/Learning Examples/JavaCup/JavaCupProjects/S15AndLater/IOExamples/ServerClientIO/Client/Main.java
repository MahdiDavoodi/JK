package ir.blog.mahdidavoodi;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    /*
     * This is the client program.
     * It will send text for server.
     * And get some text from the server!
     * */
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8765)) {
            Scanner input = new Scanner(socket.getInputStream());
            Formatter output = new Formatter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String next;
            do {
                next = scanner.next();
                output.format(next + "\n");
                output.flush();
                String received = input.next();
                System.out.println(received);
            } while (!next.equalsIgnoreCase("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
