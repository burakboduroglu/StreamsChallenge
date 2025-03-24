package com.boduroglu;

import java.util.Arrays;


/*
TASK:
Return the total number of letters in all the names with more than 5 letters
*/

public class LetterCount {

    public static void main(String[] args) {
        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("123456", "123", "1"));
    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names)
                .filter(n -> n.length() > 5)
                .mapToInt(s -> s.length())
                .sum();
    }
}
