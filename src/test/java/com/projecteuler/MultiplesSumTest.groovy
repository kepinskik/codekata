package com.projecteuler

import spock.lang.Specification
import spock.lang.Unroll

class MultiplesSumTest extends Specification {

	@Unroll
	def "sum multiples of #a and #b up to #c and get #d"() {
		given:
		MultiplesSum ms = new MultiplesSum(c)
		when:
		int sum = ms.sumMultiplesOf(a, b)
		then:
		sum == d
		where:
		a   |   b   |   c   |   d
		3   |   5   |   10  |   23
		3   |   5   |   1000|   233168
	}

}
