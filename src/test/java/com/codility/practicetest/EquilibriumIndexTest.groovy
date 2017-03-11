package com.codility.practicetest

import spock.lang.Specification


class EquilibriumIndexTest extends Specification{

	def "test"() {
		def indexer = new EquilibruimIndex()
		expect:
		indexer.solution() == -1
		indexer.solution(0) == 0
		indexer.solution(1) == 0
		indexer.solution(0, 0) == 0
		indexer.solution(1, 0) == 0
		indexer.solution(0, 1) == 1
		indexer.solution(1, 1) == -1
		indexer.solution(1, 1) == -1
		indexer.solution(1, 5) == -1
		indexer.solution(0, 0, 0) == 0
		indexer.solution(0, 0, 1) == 2
		indexer.solution(1, 0, 0) == 0
		indexer.solution(1, 2, 3) == -1
		indexer.solution(0, 2, 0) == 1
		indexer.solution(1, 2, 1) == 1
		indexer.solution(-2, -2, -2) == 1
		indexer.solution(2, 2, 2, 2) == -1
		indexer.solution(-2, -2, -2, -2) == -1
		indexer.solution(0, -2, -2, -2) == 2
		indexer.solution(-2, -2, -2, 0) == 1
		indexer.solution(1, 0, 0, 1) == 1
		indexer.solution(-1, 3, -4, 5, 1, -6, 2, 1) == 1
	}

}
