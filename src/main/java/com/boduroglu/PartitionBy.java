package com.boduroglu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;

/*
Partition these people into adults and kids, you'll need a special collector for this one
*/
public class PartitionBy {
    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);

        System.out.println(partitionAdults(collection));
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.toList()));
    }


}
