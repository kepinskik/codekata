package com.codility.practicetest;

import java.util.Arrays;
import java.util.OptionalInt;

public class BinaryGap {
    public int solution(int N) {
        return calculateGap(binaryString(N));
    }

    public int calculateGap(String binaryRep) {
        OptionalInt ifMaxExists =
                Arrays.asList(binaryRep
                                .replaceAll("^[0]+", "")
                                .replaceAll("[0]+$", "")
                    .split("1"))
                .stream()
                .mapToInt(it -> it.length())
                .max();
        return ifMaxExists.orElse(0);
    }

    public String binaryString(int p) {
        return Integer.toBinaryString(p);
    }
}
