package davoodi.mahdi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3Challenge1 {
    record Person(String name, Integer age) {
    }

    record Car(String make, String color, Float price) {
    }

    record Employee(String name, Integer age, String jobTitle, Float salary) {
    }

    public static void main(String[] args) {
        // People
        Person[] peopleArr = {
                new Person("Brandon", 23),
                new Person("Hank", 43),
                new Person("Jenna", 33),
                new Person("Veronica", 56),
                new Person("Jack", 27),
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

        // Answer 1 goes here
        List<String> people_names = people.stream().map(p -> p.name).collect(Collectors.toList());
        System.out.println("---> People names : " + people_names);

        // Cars
        Car[] carsArr = {
                new Car("Chevy", "red", 45000f),
                new Car("Ford", "blue", 23000f),
                new Car("Toyota", "grey", 14000f),
                new Car("Lamborghini", "blue", 150000f),
                new Car("Renault", "blue", 150000f),
        };
        List<Car> cars = new ArrayList<>(Arrays.asList(carsArr));
        // Answer 2 goes here
        List<Car> blueCars = cars.stream()
                .filter(car -> car.color.equalsIgnoreCase("Blue"))
                .collect(Collectors.toList());

        // Will print names to understand what happened.
        System.out.println("---> Blue cars: " + blueCars.stream().map(car -> car.make).collect(Collectors.toList()));

        // Employee
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // Answer 3 goes here
        Float salaries = employees.stream()
                .map(employee -> employee.salary).reduce(0f,
                        Float::sum);
        System.out.println("---> All salaries: " + salaries);
    }
}


