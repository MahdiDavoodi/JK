import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> gradingStudents(List<Integer> grades) {
        int newGrade = 0;
        boolean flag;
        List<Integer> newGrades = new ArrayList<>();
        for (int grade :
                grades) {
            flag = false;

            if (grade > 37) for (int i = grade; i < grade + 3; i++) {
                if (i % 5 == 0) {
                    flag = true;
                    newGrade = i;
                }
            }
            if (grade < 40 && !flag) newGrade = grade;
            if (!flag) newGrade = grade;
            newGrades.add(newGrade);
        }
        return newGrades;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
