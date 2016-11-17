package com.projecteuler


class LargestConsecutiveDigitsProduct {

	List digits

	def LargestConsecutiveDigitsProduct(int ... digits) {
		this.digits = digits.toList()
	}

	def LargestConsecutiveDigitsProduct(String digits) {
		this.digits = digits.split("(?! ^)").collect { it->
			it.toLong()
		}
	}

	def findLargestProduct(int count) {
		if( 0 == count ) return 0;
		if ( count > digits.size() )
			throw new IllegalArgumentException("Requested factors count $count exceeds size of input sequence: ${digits.size()}")
		else {
			long max = 0
			for (int i = 0; i + count <= digits.size(); i++) {
				def sublist = digits.subList(i, i + count)
				long subproduct = sublist.inject(1) { result, f ->
					result * f
				}
				max = [max, subproduct].max()
				println "Calculating sequence ${sublist} at index $i with result $subproduct and max $max"
			}
			return max
		}
	}

}
