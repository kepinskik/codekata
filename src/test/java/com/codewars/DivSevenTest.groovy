package com.codewars

import org.junit.Test
import spock.lang.Specification

import static com.codewars.DivSeven.seven

public class DivSevenTest extends Specification {
	@Test
	public void "should return correct pair" () {
		when: null
		then:
		[0, 0] as long[] == seven(0)
		[1, 0] as long[] == seven(1)
		[35, 0] as long[] == seven(35)
		[35, 1] as long[] == seven(371)
		[42, 1] as long[] == seven(483)
		[7, 2] as long[] == seven(1603)
		[28, 7] as long[] == seven(477557101)
	}
}
