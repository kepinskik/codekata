package com.projecteuler

import spock.lang.Specification


class PythagoreanTripletTest extends Specification {
	def pTriplet = new PythagoreanTriplet()

	def "should return triplets"() {
		expect:
		pTriplet.getTriplets(1) == [[1, 1, 1]]
		pTriplet.getTriplets(2) == [[1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 2, 2], [2, 2, 1], [2, 1, 2], [2, 2, 2]]
	}

	def "should filter out pithagorean triplets"() {
		expect:
		pTriplet.getTriplets(1000).findAll {it -> pTriplet.isPithagorean(it[0], it[1], it[2])} == [[3, 4, 5]]
	}

	def "should detect pithagorean"() {
		expect:
		pTriplet.isPithagorean(200, 375, 425) == true
	}
}
