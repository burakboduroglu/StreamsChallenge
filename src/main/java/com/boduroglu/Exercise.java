package com.boduroglu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Exercises
// 1- Filtering with Multiple Conditions: Filter the list to find all people who are older than 25 years and live in either "New York" or "Los Angeles".
// 2- Mapping with Transformation: Create a list of strings containing the names of all people in uppercase.
// 3- Sorting with Comparator: Sort the list of people first by city in ascending order, and then by age in descending order within each city.
// 4- Grouping and Counting: Group the list of people by their city, and then count the number of people in each city.
// 5- Aggregation with Mapping: Calculate the average age of people in each city.
// 6- Finding with Mapping: Find the oldest person in each city.
// 7- FlatMap Operation: Create a list of all unique cities where the people live.
// 8- Partitioning: Partition the list of people into two groups: one containing people older than 30 years and the other containing people younger than or equal to 30 years.
// 9- Reducing Operation: Find the person with the longest name in the list.
// 10- Advanced Filtering: Filter the list to find all people whose name contains the letter 'a', and then count the number of distinct cities they live in.

public class Exercise {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Abby", 45, "New York"));
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Adam", 55, "Chicago"));
        people.add(new Person("Bob", 30, "Los Angeles"));
        people.add(new Person("Charlie", 35, "Chicago"));
        people.add(new Person("Daniel", 22, "Seattle"));
        people.add(new Person("Seth", 16, "San Francisco"));
        people.add(new Person("Kai", 34, "Seattle"));
        people.add(new Person("David", 40, "San Francisco"));
        people.add(new Person("Ken", 37, "Los Angeles"));
        people.add(new Person("Tom", 79, "New York"));
        people.add(new Person("ObuObuhakamitabuha:)", 39, "Uganda"));
        people.add(new Person("Jonathan", 19, "Los Angeles"));
        people.add(new Person("Jane", 29, "Los Angeles"));

        // Exercise-1 | Filtering with Multiple Conditions:
        System.out.println("Exercise - 1");
        List<Person> exercise1 = people.stream()
                .filter(person -> person.getAge() > 25)
                .filter(person -> person.getNationality().equals("New York") || person.getNationality().equals("Los Angeles"))
                .toList();
        exercise1.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Exercise-2 | Mapping with Transformation:
        System.out.println("Exercise - 2");
        List<String> exercise2 = people.stream()
                .map(person -> person.getName().toUpperCase())
                .toList();
        exercise2.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Exercise-3 | Sorting with Comparator:
        System.out.println("Exercise - 3");
        List<Person> sortedByCity = people.stream()
                .sorted(Comparator.comparing(person -> person.getNationality())).toList();
        System.out.println("Sorted By City");
        sortedByCity.forEach(System.out::println);

        List<Person> sortedByAge = people.stream()
                        .sorted(Comparator.comparing(person -> person.getAge())).toList().reversed();
        System.out.println("Sorted By Age");
        sortedByAge.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Exercise-4 | Grouping and Counting:
        System.out.println("Exercise - 4");
        people.stream()
                .collect(Collectors.groupingBy(Person::getNationality))
                .forEach((city, p) -> System.out.printf("%s -> %d\n", city, p.size()));
        System.out.println("------------------------------------------------------------------");

        // Exercise-5 | Aggregation with Mapping:
        System.out.println("Exercise - 5");
        people.stream()
                .collect(Collectors.groupingBy(Person::getNationality))
                .forEach((city, p) -> {
                    double avg = p.stream().mapToInt(Person::getAge).average().orElse(0.0);
                    System.out.printf("%s -> %.2f\n", city, avg);
                });
        System.out.println("------------------------------------------------------------------");

        // Exercise-6 | Finding with Mapping:
        System.out.println("Exercise - 6");
        people.stream()
                .collect(Collectors.groupingBy(Person::getNationality))
                .forEach((city, p) -> {
                    Person oldestPerson = p.stream().max(Comparator.comparing(Person::getAge)).get();
                    System.out.printf("%s -> %d\n", oldestPerson.getName(), oldestPerson.getAge());
                });
        System.out.println("------------------------------------------------------------------");

        // Exercise-7 | FlatMap Operation:
        System.out.println("Exercise - 7");
        List<String> exercise7 = people.stream().map(Person::getNationality).distinct().toList();
        exercise7.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        // Exercise-8 | Partitioning:
        System.out.println("Exercise - 8");
        List<Person> older30 = people.stream()
                .filter(p -> p.getAge() > 30)
                .toList();
        System.out.println("Older 30");
        older30.forEach(System.out::println);

        List<Person> younger30 = people.stream()
                .filter(p -> p.getAge()<30)
                .toList();
        System.out.println("Younger 30");
        younger30.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        // Exercise-9 | Reducing Operation:
        System.out.println("Exercise - 9");
        Person longestName = people.stream().max(Comparator.comparing(p->p.getName().length())).get();
        System.out.println(longestName.getName());
        System.out.println("-----------------------------------------------------------------");

        // Exercise-10 | Advanced Filtering:
        System.out.println("Exercise - 10");
        people.stream()
                .filter(p->p.getName().contains("a"))
                .map(Person::getNationality)
                .distinct()
                .toList()
                .forEach(System.out::println);
    }
}
