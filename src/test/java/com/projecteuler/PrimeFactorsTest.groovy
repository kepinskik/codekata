package com.projecteuler

import spock.lang.Specification
import spock.lang.Unroll


class PrimeFactorsTest extends Specification {

	@Unroll
	def "max prime factor of #a is #b" () {
		expect:
		PrimeFactors.maxPrimeFactor(a) == b
		where:
		a   |   b
		2   |   2
		6   |   3
		8   |   2
		3   |   3
		4   |   2
		9   |   3
		10  |   5
		13  |   13
		16  |   2
		20  |   5
		24  |   3
		30  |   5
		600851475143 | 6857
	}

}
