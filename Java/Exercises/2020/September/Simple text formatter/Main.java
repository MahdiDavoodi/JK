package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get number from the user.
        System.out.println("The number of chars:");
        System.out.print("------> ");
        Scanner scanner = new Scanner(System.in);
        int numberOfChars = scanner.nextInt();
        scanner.close();

        readAndWrite(numberOfChars);
    }


    private static void readAndWrite(int numberOfChars) {

        try {

            File file = new File("/home/mahdi/IdeaProjects/JavaFirstProject/input.txt");
            if (file.exists()) {

                // Create reader and writer.
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));


                String line;
                String temp = "";
                String outLine = "";
                while ((line = reader.readLine()) != null) {

                    String lineTrim = temp + line.trim();
                    temp = "";

                    while (lineTrim.length() >= numberOfChars) {


                        // We have to check string length.
                        if (lineTrim.length() >= numberOfChars) {
                            int i;
                            for (i = numberOfChars; i > 0; i--) {
                                if (lineTrim.charAt(i) == ' ') {

                                    outLine = lineTrim.substring(0, i);
                                    outLine = splitSpace(outLine, numberOfChars);
                                    lineTrim = lineTrim.substring(i + 1);
                                    break;

                                }
                            }
                            if (i == 0) {
                                outLine = lineTrim.substring(0, numberOfChars);
                                lineTrim = lineTrim.substring(numberOfChars);
                            }


                        }

                        writer.write(outLine + "\n");
                        writer.flush();
                    }

                    int dotIndex = lineTrim.lastIndexOf('.');

                    if (lineTrim.length() < numberOfChars) {

                        if (dotIndex + 1 == lineTrim.length()) {
                            outLine = lineTrim + "\n";
                            writer.write(outLine);
                            writer.flush();
                        } else {
                            temp = lineTrim;
                        }
                        lineTrim = "";

                    }
                }
                writer.close();

            } else {
                System.out.println("File does not exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // To split spaces. (It is not the best way.)
    private static String splitSpace(String outLine, int numberOfChars) {
        int outLineLength = outLine.length();
        int dif = numberOfChars - outLineLength;
        String result = "";
        for (int i = 0; i < outLineLength; i++) {
            if (outLine.charAt(i) == ' ' && dif > 0) {
                result += outLine.charAt(i);
                dif--;
            }
            result += outLine.charAt(i);
        }
        return result;
    }
}
