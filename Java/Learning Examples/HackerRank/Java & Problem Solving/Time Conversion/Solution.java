import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    static String timeConversion(String input) {
        DateFormat inputDateFormat = new SimpleDateFormat("hh:mm:ssaa"),
                outputDateFormat = new SimpleDateFormat("HH:mm:ss");
        String output = null;
        Date date = null;
        try {
            date = inputDateFormat.parse(input);
            output = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
// Got help from the StackOverflow again!
