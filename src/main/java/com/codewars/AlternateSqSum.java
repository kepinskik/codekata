package com.codewars;

public class AlternateSqSum {

    public static int alternateSqSum(int[] arr) {
        int altSum = 0;
        for (int toBeProcessed = 0; toBeProcessed < arr.length; toBeProcessed++) {
            if( shouldIndexBeSquared(toBeProcessed) ) {
                altSum += square(arr[toBeProcessed]);
            }
            else {
                altSum += arr[toBeProcessed];
            }
        }
        return altSum;
    }

    private static boolean shouldIndexBeSquared(int index) {
        return index % 2 == 1;
    }

    private static int square(int arg) {
        return arg*arg;
    }
}
