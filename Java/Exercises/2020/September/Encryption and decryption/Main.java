package ir.blog.mahdidavoodi;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: <inputFile> <outputFile> <Dec/Enc> <Key - number>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        boolean isDecrypt = args[2].equalsIgnoreCase("Dec");
        String key = args[3];

        System.out.println("Try to " + (isDecrypt ? "DECRYPT" : "ENCRYPT")
                + " File: " + inputFile +
                " to " + outputFile +
                " with this key: " + key
        );
        doCrypt(inputFile, outputFile, isDecrypt, key);
    }

    private static void doCrypt(String inputFile, String outputFile, boolean isDecrypt, String key) {
        try {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile));


            byte[] buffer = new byte[key.length()];
            int n;

            while ((n = reader.read(buffer, 0, key.length())) > 0) {
                // Process
                if (isDecrypt) {
                    decrypt(buffer, n, key);
                } else {
                    encrypt(buffer, n, key);
                }
                // Write
                writer.write(buffer, 0, n);
            }

            writer.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void decrypt(byte[] buffer, int len, String key) {

        int k = Integer.parseInt(key);
        for (int i = 0; i < len; i++) {
            buffer[i] = (byte) (buffer[i] ^ k);
            buffer[i] = (byte) (255 - buffer[i]);
        }
    }

    private static void encrypt(byte[] buffer, int len, String key) {

        int k = Integer.parseInt(key);
        for (int i = 0; i < len; i++) {
            buffer[i] = (byte) (255 - buffer[i]);
            buffer[i] = (byte) (buffer[i] ^ k);
        }
    }

}
