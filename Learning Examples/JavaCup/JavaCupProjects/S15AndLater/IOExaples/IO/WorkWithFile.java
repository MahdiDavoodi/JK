package ir.blog.mahdidavoodi;

import java.io.File;

public class WorkWithFile {
    public static void main(String[] args) {
        /*
         * Some examples for working with files and directories.
         * */
        File file = new File("Hello.txt");
        System.out.println("---> File does exist: " + file.exists());
        System.out.println("---> File's name: " + file.getName());
        System.out.println("---> File's length: " + file.length());
        System.out.println("---> File's full address: " + file.getAbsolutePath());
        System.out.println("---> Can read this file: " + file.canRead());
        System.out.println("\n\n\n\n\n\n\n");

        File directory = new File("/home/mahdi/IdeaProjects/IOExamples");
        System.out.println("---> Directory's name: " + directory.getName());
        System.out.println("---> Can read this directory: " + directory.canRead());
        System.out.println("---> This is a directory: " + directory.isDirectory());
        System.out.println("---> This is a file: " + directory.isFile());
        System.out.println("---> Last modified: " + directory.lastModified());
        System.out.println("---> Directory's files: ");
        String[] files = directory.list();
        int counter = 1;
        if (files != null)
            for (String fileName :
                    files) {
                System.out.println("---> " + counter + ". " + fileName);
                counter++;
            }
    }
}
