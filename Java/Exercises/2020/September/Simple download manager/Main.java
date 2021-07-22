package com.company;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // At first we need to read URL from the file that named "Download.txt".
        // Remember that you have to create "Download.txt" and get its address to your code.
        // Each line for an URL.
        readDownloadTxt();


    }

    private static void readDownloadTxt() {

        try {
            File file = new File("C:\\Users\\Mahdi Davoodi\\IdeaProjects\\ThirdProject\\Download.txt");            // You can input another file from your device
            if (file.exists()) {
                System.out.println("------- Files -------");
                System.out.println("");
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                String line;
                int fileCounter = 1;
                while ((line = buffer.readLine()) != null) {

                    System.out.println("----> Downloading the file number " + fileCounter + " ---");

                    // Recognize the format of file from the url
                    // Notice: This is not the correct way but as you know, I'm just an amateur programmer for now :)
                    String fileFormat = line.substring(line.length() - 3, line.length());
                    String fileName = "fileNumber" + fileCounter + "." + fileFormat;

                    // Download the file
                    download(line, fileName);
                    System.out.println(fileName + " ---- Downloaded!");

                    // Increase the counter
                    fileCounter++;
                }
            } else {
                System.out.println(file.getAbsolutePath() + " does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void download(String url, String fileName) throws Exception {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
}
