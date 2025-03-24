package com.boduroglu;

import java.util.List;
import static java.util.Arrays.asList;

/*
Sum all elements of a collection, try to use the reduce operator
*/

public class SumAndReduce {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        System.out.println(calculate(numbers));
    }

    public static int calculate(List<Integer> numbers) {

        return numbers.stream()
                .reduce(0, (sum, number) -> sum + number);
    }
}
