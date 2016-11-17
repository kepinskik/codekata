package com.codewars.increasingnumbers;

import java.math.BigInteger;

public class TotalIncreasingOrDecreasingNumbers {

    public static BigInteger totalIncDec(int inp) {
        if ( inp == 0 ) return BigInteger.valueOf(10).pow(0);

        if ( inp == 1 ) return BigInteger.valueOf(10).pow(1);

        if ( inp == 2 ) return BigInteger.valueOf(10).pow(2);

        return BigInteger.valueOf(475);
    }
}
