package com.boduroglu;

import java.util.Comparator;
import java.util.List;
import static java.util.Arrays.asList;

/*
Get the oldest person from the collection
*/

public class MaxAndComparator {
    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        System.out.println(getOldestPerson(collection).toString());
    }


    public static Person getOldestPerson(List<Person> people) {
        return  people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElse(null);
    }
}
