package com.projecteuler


class LargestPalindromeProduct {
	boolean isPalindrome(int i) {
		i.toString().reverse() == i.toString()
	}

	int getLPPofNdigitnumbers(int N) {
		def found = []
		if (N >= 1) {
			int base = (10**N) - 1
			for (int first = base; first >= 10**(N-1); first--) {
				for(int second = first; second >= 10**(N-1); second--) {
					def product = first * second
					if(isPalindrome(product)) {
						println("found $product = $first * $second for base $base")
						found.add(product)
					}
				}
			}
		}
		return found.max()
	}
}
