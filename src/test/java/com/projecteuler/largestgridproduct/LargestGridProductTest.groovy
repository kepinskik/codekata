package com.projecteuler.largestgridproduct

import spock.lang.Specification

class LargestGridProductTest extends Specification {

	def "read integer block string into list of ints"() {
		expect:
		new Grid(stringRep, size).values == outputTable
		where:
		stringRep       |   size    |   outputTable
		""              |   0       |   []
		"1"             |   1       |   [1]
		"123"           |   1       |   [123]
		"1 2 3 4"       |   2       |   [1, 2, 3, 4]
		"01 11 02 22"   |   2       |   [1, 11, 2, 22]
	}

	def "throw exception when declared size mismatches actual"() {
		when:
		new Grid("1 2 3", 2)
		then:
		def e = thrown(RuntimeException)
		e.message == "Numbers table size 3 should be equal to the size argument squared. Size declared: 2"
	}

	def "should return leftwards summable subarray"() {
		given:
		def sut = new LargestGridProduct()
		when:
		def subarray = sut.leftwards(index)
		then:
		subarray == expected
		where:
		index   |   expected
		0       |   [8, 2, 22, 97]
		1       |   [2, 22, 97, 38]
		16      |   [50, 77, 91, 8]
		17      |   []
		18      |   []
		19      |   []
		20      |   [49, 49, 99, 40]

	}
}
