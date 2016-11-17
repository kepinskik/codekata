package com.codewars;

public class DivSeven {
    public static long[] seven(long m) {
        long step = 0;
        long check = m;
        while ( check >= 100 ) {
            check = reduce(check);
            step += 1;
        }
        return new long[] {check, step};
    }

    private static long reduce(long num) {
        long lastDigit = num % 10;
        long allButLast = num / 10;
        return allButLast - 2*lastDigit;
    }
}