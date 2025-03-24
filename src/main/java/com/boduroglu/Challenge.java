package com.boduroglu;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/*
Write a method that returns a comma separated string based on a given list of integers.
Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
For example, if the input list is (3,44), the output should be 'o3,e44'.
*/

public class Challenge {
    public static void main(String[] args) {
        System.out.println(getString(asList(3,44)) + " == " + "o3,e44");
        System.out.println(getString(singletonList(3)) + " == " + "o3");
    }

    public static String getString(List<Integer> list) {
        return  list.stream().map(i -> {
            String result = "";
            if (i % 2 == 0) result += "e" + i;
            else result += "o" + i;
            return result;
        }).collect(Collectors.joining(","));
    }
}
