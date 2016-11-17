package com.projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EratostenesSew {

    private Predicate<EratostenesSew> stopper;
    private List<Long> primes;

    public EratostenesSew(Predicate<EratostenesSew> stop) {
        this.stopper = stop;
        this.primes = new ArrayList<>();
        primes.add((long) 2);
    }

    public List<Long> calculatePrimes() {
        while (stopper.test(this)) {
            findNextPrime();
        }
        return primes;
    }

    private void findNextPrime() {
        long toBeVerified = sewNextPrime();
//        System.out.println(String.format("Adding prime: %d", toBeVerified));
        primes.add(toBeVerified);
    }

    private long sewNextPrime() {
        long toBeVerified = primes.get(primes.size() - 1) + 1;
        while ( !isPrimeByTrialDivision(toBeVerified) ) {
//        while ( isDivisibleByAnyKnownPrimes(toBeVerified) ) {
            toBeVerified += 1;
        }
        return toBeVerified;
    }

    private boolean isDivisibleByAnyKnownPrimes(Long number) {
        List<Long> divisors = primes.stream().filter(
                prime -> prime > 1 && number % prime == 0
        ).collect(Collectors.toList());
        return divisors.size() > 0;
    }

    private boolean isPrimeByTrialDivision (Long number) {
        if ( number == 1 ) return false;
        if ( number < 4 ) return true;
        if ( number % 2 == 0 ) return false;
        if ( number < 9 ) return true;
        if ( number % 3 == 0 ) return false;

        double maxDivisor = Math.sqrt(number);
        long divisor = 5;
        while ( divisor <= maxDivisor ) {
            if ( number % divisor == 0 ) return false;
            if ( number % ( divisor + 2 ) == 0) return false;
            divisor += 6;
        }
        return true;
    }

    public static class MaxValueReachedPredicate implements Predicate<EratostenesSew> {

        private long max;

        public MaxValueReachedPredicate(long maxValue) {
            this.max = maxValue;
        }

        @Override
        public boolean test(EratostenesSew eratostenesSew) {
            return eratostenesSew.sewNextPrime() < max;
        }
    }

    public static class MaxNumberOfPrimesReachedPredicate implements Predicate<EratostenesSew> {

        private long max;

        public MaxNumberOfPrimesReachedPredicate(long maxNumber) {
            this.max = maxNumber;
        }

        @Override
        public boolean test(EratostenesSew eratostenesSew) {
            return eratostenesSew.primes.size() < max;
        }
    }
}
