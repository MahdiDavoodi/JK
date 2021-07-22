package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C3Challenge2 {
    record Employee(String name, Integer age, String jobTitle, Float salary) {
    }

    public static void main(String[] args) {
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
        Map<String, Float> result =
                employees.parallelStream().collect(Collectors.groupingBy(employee -> employee.jobTitle))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().parallelStream()
                                        .map(employee -> employee.salary)
                                        .reduce(0f, Float::sum) / entry.getValue().size()
                        ));

        System.out.println(result);
    }
}