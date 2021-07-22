package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * In this example we want to combine useful stream functions to get average developer salary
 * */
public class C3S7 {
    private record Person(Long salary, Integer age, String name, String job) {
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person(75000L, 28, "Jack", "Teacher"),
                new Person(95000L, 32, "Sarah", "Developer"),
                new Person(110000L, 35, "Ivar", "Developer"),
                new Person(55000L, 23, "Jessie", "Lawyer"),
                new Person(60000L, 50, "Elon", "Developer"),
        };
        List<Person> personList = new ArrayList<>(Arrays.asList(persons));

        List<Person> devs = personList
                .stream()
                .filter(person -> person.job().equalsIgnoreCase("developer"))
                .collect(Collectors.toList());

        Long sumOfSalaries = devs
                .stream()
                .map(dev -> dev.salary)
                .reduce(0L, Long::sum);
        System.out.println("---> The average salary of devs is: " + (sumOfSalaries / devs.size()));
    }
}
