package com.codility.zooplus

import spock.lang.Specification


class SolutionTest extends Specification {

	def sut = new Solution()

	def "test"() {
		expect:
		sut.solution(number) == oneCount
		where:
		number  |   oneCount
		0       |   0
		1       |   1
		2       |   1
		3       |   1
		10      |   2
		11      |   4
		12      |   5
		13      |   6
		20      |   12
		21      |   13
		100000  |   50001
	}

	def "value out of allowed range"() {
		when:
		sut.solution(invalidNumber)
		then:
		def e = thrown(RuntimeException)
		e.message == "Argument $invalidNumber is out of allowed range: [0..100 000]"
		where:
		invalidNumber | _
		-1 | _
		100001 | _
	}

	def "count ones"() {
		expect:
		sut.countOnesIn(number) == onesCount
		where:
		number  |   onesCount
		1       |   1
		2       |   0
		3       |   0
		10      |   1
		11      |   2
		12      |   1
		20      |   0
		21      |   1
		22      |   0
		100     |   1
		101     |   2
		111     |   3
	}
}
