package com.boduroglu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;

/*
Get the names of all kids under the age of 18
*/
public class UnderAge {
    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);

        System.out.println(getKidNames(collection));
    }

    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(person -> person.getName())
                .collect(Collectors.toSet());
    }

}
