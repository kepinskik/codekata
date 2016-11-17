package com.projecteuler

import spock.lang.Specification

class EratostenesSewTest extends Specification{

	def "calculate n first primes"() {
		 expect:
			calculateFirstPrimes(1) == [2]
			calculateFirstPrimes(2) == [2, 3]
			calculateFirstPrimes(3) == [2, 3, 5]
			calculateFirstPrimes(4) == [2, 3, 5, 7]
			calculateFirstPrimes(5) == [2, 3, 5, 7, 11]
			calculateFirstPrimes(6) == [2, 3, 5, 7, 11, 13]
			calculateFirstPrimes(7) == [2, 3, 5, 7, 11, 13, 17]
			calculateFirstPrimes(8) == [2, 3, 5, 7, 11, 13, 17, 19]
			calculateFirstPrimes(10001).get(10000) == 104743
	}

	def calculateFirstPrimes(Long quantity) {
		def predicate = new EratostenesSew.MaxNumberOfPrimesReachedPredicate(quantity)
		def sew = new EratostenesSew(predicate)
		return sew.calculatePrimes()
	}

	def "calculate all primes smaller than a number"() {
		expect:
			calculateAllPrimesSmallerThan(3) == [2]
			calculateAllPrimesSmallerThan(4) == [2, 3]
			calculateAllPrimesSmallerThan(5) == [2, 3]
			calculateAllPrimesSmallerThan(6) == [2, 3, 5]
			calculateAllPrimesSmallerThan(10) == [2, 3, 5, 7]
			calculateAllPrimesSmallerThan(20) == [2, 3, 5, 7, 11, 13, 17, 19]
	}

	def "find sum of all primes below 2m"() {
		expect:
		calculateAllPrimesSmallerThan(2000000).sum() == 142913828922
	}

	def calculateAllPrimesSmallerThan(Long maxValue) {
		def predicate = new EratostenesSew.MaxValueReachedPredicate(maxValue)
		def sew = new EratostenesSew(predicate)
		return sew.calculatePrimes()
	}

}
