package com.projecteuler


class MultiplesSum {
	def upTo
	public MultiplesSum(upTo = 10) {
		this.upTo = upTo-1
	}

	def sumMultiplesOf(int...ints) {
		Integer sum = 0
		(1..upTo).each { divident->
			if (ints.any { divisor-> divident % divisor == 0 }) {
				sum += divident
			}
		}
		sum
	}

}
