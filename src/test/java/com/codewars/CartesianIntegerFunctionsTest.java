package com.codewars;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;

public class CartesianIntegerFunctionsTest {

    @Test
    public void shouldSumMin() {
        assertEquals(BigInteger.valueOf(1), CartesianIntegerFunctions.sumin(1));
        assertEquals(BigInteger.valueOf(1 + 1 + 1 + 2), CartesianIntegerFunctions.sumin(2));
        assertEquals(BigInteger.valueOf(5 + 3 + 3 + 3), CartesianIntegerFunctions.sumin(3));
        assertEquals(BigInteger.valueOf(14 + 6 + 6 + 4), CartesianIntegerFunctions.sumin(4));
    }

    @Test
    public void shouldSumMax() {
        assertEquals(BigInteger.valueOf(1), CartesianIntegerFunctions.sumax(1));
        assertEquals(BigInteger.valueOf(1 + 2 + 2 + 2), CartesianIntegerFunctions.sumax(2));
        assertEquals(BigInteger.valueOf(7 + 3 + 3 + 3 + 3 + 3), CartesianIntegerFunctions.sumax(3));
        assertEquals(BigInteger.valueOf(7 + 3 + 3 + 3 + 3 + 3 + 4*7), CartesianIntegerFunctions.sumax(4));
    }

    @Test
    public void shouldSumSum() {
        assertEquals(BigInteger.valueOf(2), CartesianIntegerFunctions.sumsum(1));
        assertEquals(BigInteger.valueOf(2 + 3 + 3 + 4), CartesianIntegerFunctions.sumsum(2));
        assertEquals(BigInteger.valueOf(12 + 4 + 4 + 5 + 5 + 6), CartesianIntegerFunctions.sumsum(3));
    }


    /*
    *
    * Aceptance tests:
    *
     */

    @Test
    public void test1() {
        assertEquals(BigInteger.valueOf(55), CartesianIntegerFunctions.sumin(5));
    }

    @Test
    public void test4() {
        assertEquals(BigInteger.valueOf(372), CartesianIntegerFunctions.sumax(8));
    }
    @Test
    public void test5() {
        assertEquals(BigInteger.valueOf(576), CartesianIntegerFunctions.sumsum(8));
    }
}
