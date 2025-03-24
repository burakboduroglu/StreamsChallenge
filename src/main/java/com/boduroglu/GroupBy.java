package com.boduroglu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;

/*
Group these people by nationality.
*/
public class GroupBy {
    public static void main(String[] args) {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);

        System.out.println(groupByNationality(collection));
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.toList()));
    }
}
