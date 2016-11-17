package com.projecteuler


class PrimeFactors {

	def static maxPrimeFactor(long f) {
		long rest = f
		for (int divisor = 2; divisor*divisor <= rest; divisor++)
			while(rest > divisor && rest % divisor == 0) rest = rest / divisor
		rest
	}
}
