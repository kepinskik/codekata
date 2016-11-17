package com.projecteuler

import spock.lang.Specification
import spock.lang.Unroll


class LargestPalindromeProductTest extends Specification {
	def static LargestPalindromeProduct lpp = new LargestPalindromeProduct()

	@Unroll
	def "test palindrome number detection for #integer"() {
		expect:
		lpp.isPalindrome(integer) == shouldBe
		where:
		integer |   shouldBe
		0       |   true
		9       |   true
		10      |   false
		11      |   true
		100     |   false
		101     |   true
		123321  |   true
		12321   |   true
		123421  |   false
	}

	@Unroll
	def "test largest palindrome product of #digits digit numbers is #product" () {
		expect:
		lpp.getLPPofNdigitnumbers(digits) == product
		where:
		digits  |   product
		1       |   9
		2       |   9009
		3       |   906609
	}
}
