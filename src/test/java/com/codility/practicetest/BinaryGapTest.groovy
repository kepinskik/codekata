package com.codility.practicetest

import spock.lang.Specification


class BinaryGapTest extends Specification {

	def sut = new BinaryGap()

	def "should find length of binary gap in string representation"() {
		expect:
		sut.calculateGap("101") == 1
		sut.calculateGap("0") == 0
		sut.calculateGap("1") == 0
		sut.calculateGap("010") == 0
		sut.calculateGap("010000000") == 0
		sut.calculateGap("0000001") == 0
		sut.calculateGap("10000001") == 6
		sut.calculateGap("1000000101") == 6
		sut.calculateGap("100000011011") == 6
		sut.calculateGap("1001101001") == 2
		sut.calculateGap("11111") == 0
		sut.calculateGap("101010101") == 1
	}

	def "should convert integers to their binary representation string"() {
		expect:
		sut.binaryString(0) == "0"
		sut.binaryString(1) == "1"
		sut.binaryString(2) == "10"
		sut.binaryString(3) == "11"
		sut.binaryString(4) == "100"
	}

	def "should calculate binary gap"() {
		expect:
		sut.solution(0) == 0
		sut.solution(5) == 1
	}
}
