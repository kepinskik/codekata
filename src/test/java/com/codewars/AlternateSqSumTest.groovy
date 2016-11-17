package com.codewars

import org.junit.Test
import spock.lang.*

import static com.codewars.AlternateSqSum.alternateSqSum

public class AlternateSqSumTest extends Specification {
	@Test
	public void "test alternate sum"() {
		when: null
		then:
		alternateSqSum([] as int[]) == 0
		alternateSqSum([0] as int[]) == 0
		alternateSqSum([-1] as int[]) == -1
		alternateSqSum([-1, 1] as int[]) == 0
		alternateSqSum([1, -1] as int[]) == 2
		alternateSqSum([1, 0, 1] as int[]) == 2
		alternateSqSum([11, 12, 13, 14, 15] as int[]) == 379
		alternateSqSum([1, 2, 3, 4, 5] as int[]) == 1+2*2+3+4*4+5

	}

}