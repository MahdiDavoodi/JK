package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get number of the students and create an array for the grades
        System.out.println("Please insert the number of students.");
        System.out.print("----------->");
        Scanner scanner = new Scanner(System.in);
        int theNumberOfStudents = scanner.nextInt();
        int[] theGrades = new int[theNumberOfStudents];

        // Create file named grades.txt
        createFile(theNumberOfStudents, theGrades, scanner);

        // Read from the file we created and print the number of numbers those are higher than 10
        readFile(theNumberOfStudents);

    }

    private static void readFile(int theNumberOfStudents) {
        int[] grades = new int[theNumberOfStudents];
        int i = 0;
        try {
            File file = new File("C:\\Users\\Mahdi Davoodi\\IdeaProjects\\SecondProject\\grades.txt");            // You can input another file from your device
            if (file.exists()) {
                System.out.println("------- Grades -------");
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                String line;
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line + " -- " + passedOrFailed(Integer.parseInt(line)));
                    grades[i] = Integer.parseInt((line));
                    i++;
                }
            } else {
                System.out.println(file.getAbsolutePath() + " not exist");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Top three grades
        Arrays.sort(grades);                                               // Easiest way to sort an array
        System.out.println("");                    // Just for nothing :)
        System.out.println("--------- Top 3 ---------");
        System.out.println("First -- " + grades[i - 1]);                           // Pay attention to line 38
        if (theNumberOfStudents > 1) System.out.println("Second -- " + grades[i - 2]);
        if (theNumberOfStudents > 2) System.out.println("Third -- " + grades[i - 3]);

    }

    private static String passedOrFailed(int grade) {
        if (grade >= 10) return "Passed!";
        return "Failed!";
    }

    private static void createFile(int theNumberOfStudents, int[] theGrades, Scanner scanner) {

        // Fill the grade list
        System.out.println("Now, please insert the grades one by one.");
        for (int i = 0; i < theNumberOfStudents; i++) {
            System.out.print("----------->");
            theGrades[i] = scanner.nextInt();
        }

        // Write grades into grades.txt
        try {
            Writer writer = new FileWriter("grades.txt");          // File will create next to src folder
            for (int i = 0; i < theGrades.length; i++) {
                writer.write(String.valueOf(theGrades[i]) + "\n");         // (\n) helps us to read file easier
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
