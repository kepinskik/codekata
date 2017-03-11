package com.codility.zooplus;


public class Solution {
    public int solution(int N) {
        if (N < 0 || N > 100000) {
            throw new RuntimeException(String.format("Argument %d is out of allowed range: [0..100 000]", N));
        }
        int occurrencesOfOne = 0;
        for (int i = N; i > 0; i--) {
            occurrencesOfOne += countOnesIn(i);
        }
        return occurrencesOfOne;
    }

    protected int countOnesIn(int N) {
        if (N == 0) return 0;
        if (N % 10 == 1) return 1 + countOnesIn(N / 10);
        else return countOnesIn(N / 10);
    }
}
