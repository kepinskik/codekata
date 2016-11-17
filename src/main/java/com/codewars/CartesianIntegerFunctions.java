package com.codewars;

import java.math.BigInteger;

public class CartesianIntegerFunctions {

    public static BigInteger sumin(int n) {
        if (n == 1)
            return BigInteger.valueOf(1);
        else
            return sumin(n - 1)
                    .add(sumUpTo(n - 1).multiply(BigInteger.valueOf(2)))
                    .add(BigInteger.valueOf(n));
    }

    private static BigInteger sumUpTo(int n) {
        if (n == 0) return BigInteger.ZERO;
        else return BigInteger.valueOf(n).add(sumUpTo(n - 1));
    }

    public static BigInteger sumax(int n) {
        if (n == 1)
        return BigInteger.ONE;
        else return
                    sumax(n - 1)
                    .add(BigInteger.valueOf(n)
                            .multiply(BigInteger.valueOf(n)
                            .multiply(BigInteger.valueOf(2))
                            .subtract(BigInteger.ONE)));
    }


    public static BigInteger sumsum(int n) {
        return sumin(n).add(sumax(n));
    }
}
