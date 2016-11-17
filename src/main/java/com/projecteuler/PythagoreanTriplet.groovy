package com.projecteuler


class PythagoreanTriplet {


	def isPithagorean(a, b, c) {
		return a*a + b*b == c*c
	}

	def getTriplets(max) {
			[[max, max, max]]
	}
}
