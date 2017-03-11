package com.codility.practicetest;


public class EquilibruimIndex {

    public int solution(int[] A) {
        int zeroIndex = 0;
        int lastIndex = A.length - 1;
        if (zeroIndex <= lastIndex) {
            if (zeroIndex == lastIndex) return 0;
            long[] leftSums = new long[A.length];
            long[] rightSums = new long[A.length];
            leftSums[zeroIndex] = 0;
            rightSums[lastIndex] = 0;
            for (int i = 1; i <= lastIndex; i++) {
                leftSums[i] = leftSums[i - 1] + A[i - 1];
                rightSums[lastIndex - i] = rightSums[lastIndex - i + 1] + A[lastIndex - i + 1];
            }
            for (int i = 0; i <= lastIndex; i++) {
                if (leftSums[i] == rightSums[i]) return i;
            }
        }
        return -1;
    }
}
