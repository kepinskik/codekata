package com.projecteuler.largestgridproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {
    private List<Integer> values;


    public Grid(String numbers, int size) {
        values = new ArrayList<>();
        if (!numbers.isEmpty()) {
            values.addAll(Arrays.stream(numbers.split(" "))
                    .map(it -> new Integer(it))
                    .collect(Collectors.toList())
            );
        }
        if (values.size() != size*size) {
            throw new RuntimeException(String.format(
                    "Numbers table size %d should be equal to the size argument squared. Size declared: %d", values.size(), size));
        }
    }

    public List<Integer> getValues() {
        return values;
    }

}
