package com.projecteuler

import spock.lang.Specification

class LargestConsecutiveDigitsProductTest extends Specification {

	LargestConsecutiveDigitsProduct product1 = new LargestConsecutiveDigitsProduct("1")

	def "should find largest product"() {
		expect:
		findLargest(0, 0) == 0
		findLargest(1, 1) == 1
		findLargest(1, 0) == 0
		findLargest(1, 5) == 5
		findLargest(1, 0, 1) == 1
		findLargest(1, 1, 0, 2) == 2
		findLargest(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0) == 9
		findLargest(1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0) == 9
		findLargest(2, 0, 1) == 0
 		findLargest(2, 1, 2) == 2
		findLargest(2, 3, 2) == 6
		findLargest(3, 3, 2, 2) == 12
		findLargest(2, 3, 2, 2) == 6
		findLargest(2, 2, 2, 3) == 6
		findLargest(3, 1, 2, 3, 4, 5) == 60
		findLargest(3, 1, 2, 5, 4, 3) == 60
		findLargest(2, 1, 6, 0, 7, 1) == 7
	}

	def "should throw error when factors count exceeds input series"() {
		given:
		when:
		findLargest(2, 0)
		then:
		thrown(IllegalArgumentException)
	}

	def "should split char sequence into digits as ints"() {
		expect:
		splitIntoDigits("1") == [1]
		splitIntoDigits("10") == [1,0]
		splitIntoDigits("000") == [0,0,0]
		splitIntoDigits("""12098""") == [1,2,0,9,8]
	}

	def "should pass example test"() {
		def example = "73167176531330624919225119674426574742355349194934" +
				"96983520312774506326239578318016984801869478851843" +
				"85861560789112949495459501737958331952853208805511" +
				"12540698747158523863050715693290963295227443043557" +
				"66896648950445244523161731856403098711121722383113" +
				"62229893423380308135336276614282806444486645238749" +
				"30358907296290491560440772390713810515859307960866" +
				"70172427121883998797908792274921901699720888093776" +
				"65727333001053367881220235421809751254540594752243" +
				"52584907711670556013604839586446706324415722155397" +
				"53697817977846174064955149290862569321978468622482" +
				"83972241375657056057490261407972968652414535100474" +
				"82166370484403199890008895243450658541227588666881" +
				"16427171479924442928230863465674813919123162824586" +
				"17866458359124566529476545682848912883142607690042" +
				"24219022671055626321111109370544217506941658960408" +
				"07198403850962455444362981230987879927244284909188" +
				"84580156166097919133875499200524063689912560717606" +
				"05886116467109405077541002256983155200055935729725" +
				"71636269561882670428252483600823257530420752963450"
		def product = new LargestConsecutiveDigitsProduct(example.toString())
		expect:
		product.findLargestProduct(4) == 5832
		product.findLargestProduct(5) == 40824
		product.findLargestProduct(13) == 23514624000

	}

	def splitIntoDigits(String sequence) {
		def prod = new LargestConsecutiveDigitsProduct(sequence)
		prod.digits
	}

	def findLargest(int factorsCount, int ... digits) {
		def product = new LargestConsecutiveDigitsProduct(digits)
		product.findLargestProduct(factorsCount)
	}


}
