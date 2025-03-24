package com.boduroglu;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/*
    Flatten this multidimensional collection
*/

public class FlatMap {

    public static void main(String[] args) {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        System.out.println(transform(collection));
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
