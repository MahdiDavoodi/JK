package ir.blog.mahdidavoodi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
        /*
        * This is the server program.
        * It will wait for another program on port 8765 and respond to it.
        * This program just copy the entered text and send it to the sender!
        * */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8765)) {
            Socket socket = serverSocket.accept();
            Scanner input = new Scanner(socket.getInputStream());
            Formatter output = new Formatter(socket.getOutputStream());
            String next;
            do {
                next = input.next();
                output.format(next + "\n");
                output.flush();
            } while (!next.equalsIgnoreCase("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
