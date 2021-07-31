package ir.blog.mahdidavoodi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Example2 {
    /*
     * Some examples of NIO2 options.
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("example.txt");

        List<String> lines = Files.readAllLines(path);
        for (int i = lines.size() - 1; i >= 0; i--)
            if (lines.get(i).startsWith("Goodbye"))
                lines.remove(i);

        Files.write(Paths.get("example2.txt"), lines);
    }
}
