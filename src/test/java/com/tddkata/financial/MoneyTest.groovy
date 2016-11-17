package com.tddkata.financial

import org.junit.Test
import spock.lang.Specification

class MoneyTest extends Specification {

	static Expression fiveBucks
	static Expression tenFrancs
	static Money five
	Bank bank
	private final String USD = "USD"
	private final String CHF = "CHF"

	def initBank() {
		bank = new Bank()
		bank.addRate(CHF, USD, 2)
	}

	def setupSpec() {
		fiveBucks = Money.dollar(5)
		tenFrancs = Money.franc(10)
		five = Money.dollar(5)
	}

	@Test
	def "should multiply sum by number"() {
		given:
		initBank()
		when:
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2)
		Money result = bank.reduce(sum, USD)
		then:
		result == Money.dollar(20)
	}

	@Test
	def "should add money to sum"() {
		given:
		initBank()
		when:
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks)
		Money result = bank.reduce(sum, USD)
		then:
		result == Money.dollar(15)
	}

	@Test
	def "should add mixed currency values"() {
		given:
		initBank()
		when:
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), USD)
		then:
		result == Money.dollar(10)
	}

	@Test
	def "should return identity rate"() {
		expect:
		1 == new Bank().rate(USD, USD)
	}

	@Test
	def "should reduce money to different currency"() {
		given:
		initBank()
		when:
		Money result = bank.reduce(Money.franc(2), USD)
		then:
		result == Money.dollar(1)
	}

	@Test
	def "should add money values"() {
		given:
		Bank bank = new Bank()
		when:
		Expression sum = five.plus(five)
		Money reduced = bank.reduce(sum, USD)
		then:
		reduced == Money.dollar(10)
	}

	@Test
	def "should reduce money"() {
		given:
		Bank bank = new Bank()
		when:
		Money result = bank.reduce(Money.dollar(1), USD)
		then:
		result.equals(Money.dollar(1))
	}

	@Test
	def "should reduce sum"() {
		given:
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4))
		Bank bank = new Bank()
		when:
		Money result = bank.reduce(sum, USD)
		then:
		result.equals(Money.dollar(7))
	}

	@Test
	def "should return sum object when adding"() {
		given:
		Expression result = five.plus(five)
		when:
		Sum sum = (Sum) result
		then:
		five.equals(sum.augend)
		five.equals(sum.addend)
	}

	@Test
	def "should multiply dollars"() {
		expect:
		five.times(2).equals(Money.dollar(10))
		five.times(3).equals(Money.dollar(15))
	}

	@Test
	def "should check dollar equality"() {
		expect:
		Money.dollar(5).equals(Money.dollar(5))
		!Money.dollar(5).equals(Money.dollar(6))
	}

	@Test
	def "should check franc equality"() {
		expect:
		Money.franc(5).equals(Money.franc(5))
		!Money.franc(5).equals(Money.franc(6))
	}

	@Test
	def "should check inter-currency equality"() {
		expect:
		!Money.dollar(1).equals(Money.franc(1))
		new Money(10, USD).equals(Money.dollar(10))
	}

	@Test
	def "should return currency"() {
		expect:
		Money.dollar(1).currency() == USD
		Money.franc(1).currency() == CHF
	}
}
