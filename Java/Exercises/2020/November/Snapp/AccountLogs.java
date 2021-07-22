package ir.blog.mahdidavoodi;

import java.io.*;

public class AccountLogs {

    public final File accountLogs = new File("Logs.txt");

    public void showLogs(String currentUsername) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(accountLogs));
        String line;
        int counter = 1;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts[0].equalsIgnoreCase(currentUsername)) {
                System.out.println(Main.ANSI_BLUE + "-----> " + counter + "." + parts[1] + " to " + parts[2] + Main.ANSI_RESET);
                counter++;
            }
        }
        if (counter == 1) System.out.println(Main.ANSI_RED + "-----> We found nothing!" + Main.ANSI_RESET);
    }

    public void saveLog(String currentUsername, String startingCity, String targetCity) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(accountLogs));
        BufferedWriter writer = new BufferedWriter(new FileWriter("logsTemp.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line + "\n");
        }
        writer.close();
        reader.close();

        reader = new BufferedReader(new FileReader("logsTemp.txt"));
        writer = new BufferedWriter(new FileWriter("Logs.txt"));
        while ((line = reader.readLine()) != null) {
            writer.write(line + "\n");
        }
        writer.write(currentUsername + " ");
        writer.write(startingCity + " ");
        writer.write(targetCity + "\n");
        writer.close();
        reader.close();

        File logsTemp = new File("logsTemp.txt");
        if (logsTemp.exists()) logsTemp.delete();


    }


}

